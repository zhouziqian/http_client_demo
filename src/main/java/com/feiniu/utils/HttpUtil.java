package com.feiniu.utils;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.apache.http.impl.client.HttpClients.createDefault;

/**
 * @author zhouqi on 2017/12/14.
 */
public class HttpUtil {
    private static  final Logger log = LoggerFactory.getLogger(HttpUtil.class);
    private static final int DEFAULT_TIMEOUT = 10000;
    public static String postByJson(String url, String body) throws IOException {
        CloseableHttpClient httpClient = createDefault();
        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(DEFAULT_TIMEOUT)
                    .setConnectTimeout(DEFAULT_TIMEOUT).build();// 设置请求和传输超时时间
            httpPost.setConfig(requestConfig);
            CloseableHttpResponse response = null;
            String result = null;
            try {
                if (body == null) {
                    // pass
                } else {
                    StringEntity entity = new StringEntity(body, "UTF-8");
                    entity.setContentEncoding("UTF-8");
                    entity.setContentType("application/json");
                    httpPost.setEntity(entity);
                }
                response = httpClient.execute(httpPost);
                StatusLine statusLine = response.getStatusLine();
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity, Consts.UTF_8);
            } catch (Exception e) {
                throw e;
            } finally {
                try {
                    if (response != null) {
                        response.close();
                    }
                } catch (IOException e) {
                    throw e;
                }
            }
            return result == null ? "" : result.trim();

        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw e;
            }
        }
    }

    public static String postByMap(String url, Map<String, String> params) throws IOException {
        if (StringUtils.isEmpty(url) || params == null || params.isEmpty()) {
            return "";
        }

        CloseableHttpClient httpClient = createDefault();
        CloseableHttpResponse response = null;
        String result = null;

        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(DEFAULT_TIMEOUT)
                    .setConnectTimeout(DEFAULT_TIMEOUT).build();// 设置请求和传输超时时间

            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            List<BasicNameValuePair> basicNameValuePairs = new ArrayList<>();
            for (Map.Entry<String, String> entity : params.entrySet()) {
                basicNameValuePairs.add(new BasicNameValuePair(entity.getKey(), entity.getValue()));
            }

            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(basicNameValuePairs, Consts.UTF_8);
            httpPost.setEntity(urlEncodedFormEntity);

            response = httpClient.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();

            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, Consts.UTF_8);

            return result == null ? "" : result.trim();

        } catch (IOException e) {
            throw e;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                throw e;
            }
        }

    }
}

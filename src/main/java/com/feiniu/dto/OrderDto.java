package com.feiniu.dto;

/**
 * @author zhouqi on 2017/12/14.
 */
public class OrderDto {
    private String orderNo;
    private String appKey;
    private String version;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderNo='" + orderNo + '\'' +
                ", appKey='" + appKey + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}

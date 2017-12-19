package com.feiniu.dto;

/**
 * @author zhouqi on 2017/12/14.
 */
public class ResponseDto<T> {
    private Integer code;
    private String message;
    private T date;

    public ResponseDto(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}

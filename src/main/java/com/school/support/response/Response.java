package com.school.support.response;

public class Response<T> {

    private final static Integer SUCCESS = 200;
    private final static Integer FAIL = 500;


    private String message;
    private Integer code;
    private T data;

    private Response(String message, Integer code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    /**
     * 请求成功
     * @param message 提示信息
     * @param data 返回数据
     * @param <T>
     * @return
     */
    public static <T> Response<T> ok(String message, T data) {
        return build(SUCCESS, message, data);
    }

    /**
     * 请求成功
     * @param message 成功提示信息
     * @param <T>
     * @return
     */
    public static <T> Response<T> ok(String message) {
        return build(SUCCESS, message, null);
    }

    /**
     * 请求成功
     * @param data 返回的数据
     * @param <T>
     * @return
     */
    public static <T> Response<T> ok(T data) {
        return build(SUCCESS, "success", data);
    }

    /**
     * 请求成功
     * @param <T>
     * @return
     */
    public static <T> Response<T> ok() {
        return build(SUCCESS, "success", null);
    }

    /**
     * 请求失败
     * @param message 失败信息
     * @param <T>
     * @return
     */
    public static <T> Response<T> fail(String message) {
        return build(FAIL, message, null);
    }


    public static <T> Response<T> build(Integer code, String message, T data) {
        return new Response<>(message, code, data);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

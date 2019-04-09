package edu.eat.order.base.response;

import lombok.Getter;


public class JsonResponse<T> {

    private final static Integer SUCCESS = 200;
    private final static Integer FAIL = 500;

    @Getter
    private String message;
    @Getter
    private Integer code;
    @Getter
    private T data;

    private JsonResponse(String message, Integer code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    /**
     * 请求成功
     *
     * @param message 提示信息
     * @param data    返回数据
     * @param <T>
     * @return
     */
    public static <T> JsonResponse<T> ok(String message, T data) {
        return build(SUCCESS, message, data);
    }

    /**
     * 请求成功
     *
     * @param message 成功提示信息
     * @param <T>
     * @return
     */
    public static <T> JsonResponse<T> ok(String message) {
        return build(SUCCESS, message, null);
    }

    /**
     * 请求成功
     *
     * @param data 返回的数据
     * @param <T>
     * @return
     */
    public static <T> JsonResponse<T> ok(T data) {
        return build(SUCCESS, "success", data);
    }

    /**
     * 请求成功
     *
     * @param <T>
     * @return
     */
    public static <T> JsonResponse<T> ok() {
        return build(SUCCESS, "success", null);
    }

    /**
     * 请求失败
     *
     * @param message 失败信息
     * @param <T>
     * @return
     */
    public static <T> JsonResponse<T> fail(String message) {
        return build(FAIL, message, null);
    }


    /**
     * 构建json返回数据
     *
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> JsonResponse<T> build(Integer code, String message, T data) {
        return new JsonResponse<>(message, code, data);
    }


}

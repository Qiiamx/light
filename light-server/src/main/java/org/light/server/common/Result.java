package org.light.server.common;

public class Result<T> {
    private int code;
    private String message;
    private T data;
    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static <T> Result<T> success(T data) {
        return new Result(0, "success", data);
    }
    public static <T> Result<T> success() {
        return new Result(0, "success", null);
    }
    public static <T> Result<T> error(String message) {
        return new Result<T>(500, message, (T)null);
    }
    public static <T> Result<T> error(int code, String message) {
        return new Result<T>(code, message, (T)null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

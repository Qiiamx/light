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
    public static Result success() {
        return new Result(0, "success", null);
    }
    public static Result error(String message) {
        return new Result(500, message, null);
    }
    public static Result error(int code, String message) {
        return new Result(code, message, null);
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

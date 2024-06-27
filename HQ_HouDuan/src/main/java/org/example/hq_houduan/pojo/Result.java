package org.example.hq_houduan.pojo;

public class Result<T> {
    public int code;
    public String msg;
    public T data;
    public Result() {}
    public static<T> Result success() {
        Result result = new Result();
        result.code = 0;
        result.msg = "success";
        return result;
    }
    public static<T> Result success(T data) {
        Result result = success();
        result.data = data;
        return result;
    }
}

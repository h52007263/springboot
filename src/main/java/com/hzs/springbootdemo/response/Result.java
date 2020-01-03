package com.hzs.springbootdemo.response;

import java.util.List;

/**
 * result返回结果类
 *
 * @author hezhensheng3
 * @date 2020-01-03 9:27
 **/
public class Result<T> {
    /**
     * 应答码
     */
    private Integer code;
    /**
     * 应答信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private List<T> data;
    /**
     * 是否成功
     */
    private Boolean isSuccess = true;

    /**
     * 构建成功结果
     * @param data
     * @return
     */
    public static Result buildSuccessResult(List data) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    /**
     * 构建失败结果
     * @param code
     * @param msg
     * @return
     */
    public static Result buildFailResult(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(false);
        result.setData(null);
        return result;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * 获取成功结果
     * @return
     */
    public Boolean getSuccess() {
        return isSuccess;
    }

    /**
     * 设置success
     * @param success
     */
    public void setSuccess(Boolean success) {
        isSuccess = success;
    }
}

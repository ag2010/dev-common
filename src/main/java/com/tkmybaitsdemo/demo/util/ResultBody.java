package com.tkmybaitsdemo.demo.util;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;

public class ResultBody {
    /**
     * 响应代码
     */
    @ApiModelProperty(name = "code", notes = "响应代码")
    private String code;

    /**
     * 响应消息
     */
    @ApiModelProperty(name = "message", notes = "响应消息")
    private String message;

    /**
     * 响应结果
     */
    @ApiModelProperty(name = "result", notes = "响应结果")
    private Object result;

    public ResultBody() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ResultBody success(Object data) {
        ResultBody rb = new ResultBody();
        rb.setCode("200");
        rb.setMessage("success");
        rb.setResult(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error() {
        ResultBody rb = new ResultBody();
        rb.setCode("500");
        rb.setMessage("error");
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message) {
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String message) {
        ResultBody rb = new ResultBody();
        rb.setCode("-1");
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

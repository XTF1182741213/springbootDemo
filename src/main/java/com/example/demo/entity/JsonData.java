package com.example.demo.entity;

import java.util.List;
/**
 * @Author:fly
 * @Description: the JSONDate ,it will return ,to Api interface
 * @Date:17:02 2018/8/1
 */
public class JsonData {
    private int code;
    private String msg;
    private List data;

    public JsonData(int code, String msg, List data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}

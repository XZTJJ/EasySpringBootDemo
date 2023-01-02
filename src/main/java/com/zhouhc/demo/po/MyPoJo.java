package com.zhouhc.demo.po;

/**
 * 自定义pojo,主要用于测试
 */
public class MyPoJo {
    private String textStr;
    private String valueStr;

    public MyPoJo(String textStr, String valueStr) {
        this.textStr = textStr;
        this.valueStr = valueStr;
    }

    public String getTextStr() {
        return textStr;
    }

    public void setTextStr(String textStr) {
        this.textStr = textStr;
    }

    public String getValueStr() {
        return valueStr;
    }

    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
    }

}

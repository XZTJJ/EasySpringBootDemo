package com.zhouhc.demo.po;

import java.time.LocalDateTime;

public class MyDate {

    private LocalDateTime localDateTime;
    private Integer integer;

    public MyDate(LocalDateTime localDateTime, Integer integer) {
        this.localDateTime = localDateTime;
        this.integer = integer;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

}

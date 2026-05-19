package com.belkiz.demo.rest;

public class StudentErrorResponse {

    private int status;
    private String message;
    private long time_stamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String message, long time_stamp) {
        this.status = status;
        this.message = message;
        this.time_stamp = time_stamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(long time_stamp) {
        this.time_stamp = time_stamp;
    }
}

package com.qf.house.dto;

/**
 * @author yangbo
 */
public class CheckResult {
    private String uesrname;
    private boolean valid;
    private String message;
    private String picture;

    public CheckResult() {
    }

    public CheckResult(String username,boolean valid, String message, String picture) {
        this.uesrname=username;
        this.valid = valid;
        this.message = message;
        this.picture = picture;
    }

    public String getUesrname() {
        return uesrname;
    }

    public void setUesrname(String uesrname) {
        this.uesrname = uesrname;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

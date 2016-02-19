package com.jumbo.exception;

public class SystemException extends Exception {
    private static final long serialVersionUID = 2564963972366467361L;

    private int code;
    
    private String detail;

    public SystemException() {}
    
    public SystemException(String detail) {
        super(detail);
        this.detail = detail;
    }
    
    public SystemException(String detail, Throwable cause) {
        super(detail, cause);
        this.detail = detail;
    }

    public SystemException(int code, String detail) {
        super(detail);
        this.code = code;
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    
}

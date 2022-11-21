package com.ach.calendfi.customexception;

public enum CommonEnum implements BaseErrorInfoInterface {
    // Data manipulation error definition
    SUCCESS("200", "Success"),
    BODY_NOT_MATCH("400", "The requested data format does not match!"),
    SIGNATURE_NOT_MATCH("401", "The requested digital signature does not match!"),
    NOT_FOUND("404", "The resource was not found!"),
    INTERNAL_SERVER_ERROR("500", "Server internal error!"),
    SERVER_BUSY("503", "Server is busy. Please try later!");

    /**
     * error code
     */
    private String resultCode;

    /**
     * wrong description
     */
    private String resultMsg;

    CommonEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }

}

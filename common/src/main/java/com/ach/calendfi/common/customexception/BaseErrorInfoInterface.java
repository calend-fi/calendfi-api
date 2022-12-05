package com.ach.calendfi.common.customexception;

public interface BaseErrorInfoInterface {

    /**
     * error code
     */
    String getResultCode();

    /**
     * wrong description
     */
    String getResultMsg();
}

package com.ach.calendfi.customexception;

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

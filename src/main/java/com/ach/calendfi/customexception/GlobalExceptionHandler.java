package com.ach.calendfi.customexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handle custom business exceptions
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = AchException.class)
    @ResponseBody
    public ResultBody bizExceptionHandler(HttpServletRequest req, AchException e) {
        logger.error("A business exception occurred! The reason is：{}", e.getErrorMsg());
        return ResultBody.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * Handling the exception of a null pointer
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e) {
        logger.error("A null pointer exception occurred! The reason is:", e);
        return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
    }


    /**
     * Handle other exceptions
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("Unknown exception! The reason is:", e);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}


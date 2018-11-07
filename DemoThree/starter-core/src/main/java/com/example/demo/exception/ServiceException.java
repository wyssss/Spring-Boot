package com.example.demo.exception;

/**
 * Service层异常
 *
 * @author bojiangzhou 2017-12-31
 * @version 1.0
 */
public class ServiceException extends BaseException {
    private static final long serialVersionUID = 6058294324031642376L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String code, String message) {
        super(code, message);
    }

}
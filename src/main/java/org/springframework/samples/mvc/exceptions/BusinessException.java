package org.springframework.samples.mvc.exceptions;

@SuppressWarnings("serial")
public class BusinessException extends Exception {

    public BusinessException(String message) {
        super(message);
    }

}

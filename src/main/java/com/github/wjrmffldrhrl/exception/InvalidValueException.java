package com.github.wjrmffldrhrl.exception;


/**
 * Invalid index exception
 *
 * @author wjrmffldrhrl
 */
public class InvalidValueException extends RuntimeException{
    /**
     * Throw InvalidIndexException
     * @param e String
     */
    public InvalidValueException(String e) { super(e); }
}

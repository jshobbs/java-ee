package com.jeffhobbsonline.dango.service.exception;

//import com.jeffhobbsonline.dango.service.exception.ErrorCode;
//import com.jeffhobbsonline.dango.service.exception.DangoException;

@SuppressWarnings("serial")
public class InvalidFieldException extends DangoException {

	public InvalidFieldException(String message, Throwable throwable) {
		super(ErrorCode.INVALID_FIELD, message, throwable);
	}
		
	public InvalidFieldException(String message) {
		super(ErrorCode.INVALID_FIELD, message);
	}
}
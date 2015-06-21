package com.jeffhobbsonline.dango.service.exception;

import com.jeffhobbsonline.dango.service.exception.ErrorCode;

@SuppressWarnings("serial")
public class DangoException extends RuntimeException {

	private ErrorCode errorCode;

	public DangoException(ErrorCode code, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = code;
	}
		
	public DangoException(ErrorCode code, String message) {
		super(message);
		this.errorCode = code;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
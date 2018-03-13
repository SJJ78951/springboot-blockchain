package com.sjj.springboot.exception;

public class ServerException extends RuntimeException {
	private static final long serialVersionUID = -460587978979800734L;
	
	private String code;

	public ServerException() {

	}

	public ServerException(String msg) {
		super(msg);
	}

	public ServerException(String code, String msg) {
		super(msg);
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}

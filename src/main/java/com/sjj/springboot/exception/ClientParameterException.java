package com.sjj.springboot.exception;

public class ClientParameterException extends RuntimeException {

	private static final long serialVersionUID = -460583000140800734L;
	private String code;

	public ClientParameterException() {

	}

	public ClientParameterException(String msg) {
		super(msg);
	}

	public ClientParameterException(String code, String msg) {
		super(msg);
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}

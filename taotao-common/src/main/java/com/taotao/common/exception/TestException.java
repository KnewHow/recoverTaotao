package com.taotao.common.exception;

/**
 * 
 * @author yuanghohao
 * 
 * @company erongdu
 *
 * @date 2017年9月17日
 */
public class TestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestException() {
		super();
	}

	public TestException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TestException(String message, Throwable cause) {
		super(message, cause);
	}

	public TestException(String message) {
		super(message);
	}

	public TestException(Throwable cause) {
		super(cause);
	}

	
	
}

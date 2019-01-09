package com.talelife.framework.exception;

/**
 * 业务运行异常
 * @author Liuweiyao
 *
 */
public class UnLoginException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7331592920433471715L;

	public UnLoginException() {
		super();
	}

	public UnLoginException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UnLoginException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UnLoginException(String arg0) {
		super(arg0);
	}

	public UnLoginException(Throwable arg0) {
		super(arg0);
	}
	

}

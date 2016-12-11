package com.okorkut.ik.common.exception;

/** Exception if there's problem on the type conversion
 * 
 *
 */
public class TypeConverterException extends RuntimeException {
	
	private static final long serialVersionUID = 1795839845839523235L;

	public TypeConverterException() {
		super();
	}

	public TypeConverterException(String message, Throwable cause) {
		super(message, cause);
	}

	public TypeConverterException(String message) {
		super(message);
	}

	public TypeConverterException(Throwable cause) {
		super(cause);
	}

}

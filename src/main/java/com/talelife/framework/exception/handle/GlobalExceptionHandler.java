package com.talelife.framework.exception.handle;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.talelife.framework.entity.ResponseEntity;
import com.talelife.framework.exception.BusinessException;
import com.talelife.framework.exception.UnLoginException;

@ControllerAdvice(basePackages = "com.talelife")
@ResponseBody
public class GlobalExceptionHandler {
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 未登录异常
	 */
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(UnLoginException.class)
	public ResponseEntity<?> handleHttpMessageNotReadableException(UnLoginException e) {
		logger.error("未登陆", e);
		return ResponseEntity.fail(ExceptionCodeEnum.UNAUTHORIZED.getCode(),ExceptionCodeEnum.UNAUTHORIZED.getMessage());
	}
	
	/**
	 * 传入参数异常
	 */
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(BindException.class)
	public ResponseEntity<?> handleBindException(BindException e) {
		logger.error("参数错误", e);
		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		StringBuilder message = new StringBuilder("[");
		for (FieldError fieldError : fieldErrors) {
			message.append(fieldError.getDefaultMessage()).append("(").append(fieldError.getField()).append(")").append(",");
		}
		if(message.length()>1){
			message.deleteCharAt(message.length()-1);
		}
		message.append("]");
		return ResponseEntity.fail(ExceptionCodeEnum.PARAMETER_ERROR.getCode(),message.toString());
	}
	
	/**
	 * 统一业务异常
	 */
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleBusinessException(BusinessException e) {
		logger.error("业务异常", e);
		return ResponseEntity.fail(ExceptionCodeEnum.BUSINESS_ERROR.getCode(),e.getMessage());
	}

	/**
	 * 未知异常
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e) {
		logger.error("服务运行异常", e);
		return ResponseEntity.fail(ExceptionCodeEnum.SYSTEM_ERROR.getCode(),ExceptionCodeEnum.SYSTEM_ERROR.getMessage());
	}
	
	public enum ExceptionCodeEnum{
		SYSTEM_ERROR("0001", "系统错误"),
		UNAUTHORIZED("0002", "未登陆"),
		PARAMETER_ERROR("0003", "参数错误"),
		BUSINESS_ERROR("0004", "统一业务错误");
	    private String code;
	    private String message;

	    private ExceptionCodeEnum(String code, String message) {
	        this.code = code;
	        this.message = message;
	    }

		public String getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}
	}
}
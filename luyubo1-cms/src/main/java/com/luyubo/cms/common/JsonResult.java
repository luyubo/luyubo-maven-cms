package com.luyubo.cms.common;

import java.io.Serializable;

public class JsonResult implements Serializable{
	/**   
	 * @Fields serialVersionUID : TODO(这个变量表示什么)   
	 */  
	private static final long serialVersionUID = 1L;
	private boolean result;
	private int errorCode;
	private String message;
	private Object data;
	
	/**
	 * 成功
	 * @param date
	 * @return
	 */
	public static JsonResult success(Object date) {
		return new JsonResult(true,0,null,date);
	}
	
	public static JsonResult success() {
		return new JsonResult(true,0,null,null);
	}
	
	/**
	 * 失败
	 * @param errorCode
	 * @param date
	 * @return
	 */
	public static JsonResult fail(int errorCode,String message) {
		return new JsonResult(false,errorCode,message,null);
	}
	
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public JsonResult(boolean result, int errorCode, String message, Object data) {
		super();
		this.result = result;
		this.errorCode = errorCode;
		this.message = message;
		this.data = data;
	}

	public JsonResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

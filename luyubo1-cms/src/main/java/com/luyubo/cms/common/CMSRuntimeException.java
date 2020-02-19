package com.luyubo.cms.common;

import java.beans.ExceptionListener;
/**
 * 定义的自定义异常
 * @author 77028
 *
 */
public class CMSRuntimeException implements ExceptionListener{

	@Override
	public void exceptionThrown(Exception e) {
		// TODO Auto-generated method stub
		String message = e.getMessage();
	}

}

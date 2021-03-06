package com.luyubo.cms.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthAdminInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object attribute = request.getSession().getAttribute(CmsConstant.UserAdminSessionKey);
		if(attribute!=null) {
			return true;
		}
		response.sendRedirect("/admin/");
		return false;
	}
}

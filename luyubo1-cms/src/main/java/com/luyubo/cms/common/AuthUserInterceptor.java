package com.luyubo.cms.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.bawei.commons.utils.StringUtil;
import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.UserService;


public class AuthUserInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object userInfo = request.getSession().getAttribute(CmsConstant.UserSessionKey);
		if(userInfo!=null) {
			return true;
		}
		String username = CookieUtil.getCookieByName(request, "username");
		if(StringUtil.isBlank(username)) {
			UserService bean = SpringBeanUtils.getBean(UserService.class);
			User user = bean.getByUsername(username);
			request.getSession().setAttribute(CmsConstant.UserSessionKey, user);
			return true;
		}
	    response.sendRedirect("/user/login");
		return false;
	}
}

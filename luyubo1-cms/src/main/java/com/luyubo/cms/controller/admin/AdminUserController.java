package com.luyubo.cms.controller.admin;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luyubo.StringUtil;
import com.luyubo.cms.common.CmsConstant;
import com.luyubo.cms.common.CmsMd5Util;
import com.luyubo.cms.common.JsonResult;
import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.UserService;
/**
 * 
 * @author 77028
 *
 */
@Controller
@RequestMapping("/admin/user/")
public class AdminUserController {
	@Autowired
	private UserService userService;

	@RequestMapping("login")
	@ResponseBody
	public Object login(User user,HttpSession session) {
		boolean blank = StringUtil.isBlank(user.getUsername());
		boolean blank1 = StringUtil.isBlank(user.getPassword());
		if(blank==false || blank1==false) {
			return JsonResult.fail(1000, "用户名和密码不能为空");
		}
		//查询用户
		User userInfo = userService.getByUsername(user.getUsername());
		//判断是否管理员
		if(userInfo==null) {
			return JsonResult.fail(1000, "用户名或密码错误");
		}
		//判断是否管理员
		if(!userInfo.isAdmin()) {
			return JsonResult.fail(1000, "权限不足");
		}
		//判断密码
		String string2md5 = CmsMd5Util.string2MD5(user.getPassword());
		if(string2md5.equals(userInfo.getPassword())) {
			session.setAttribute(CmsConstant.UserAdminSessionKey, userInfo);
			return JsonResult.success();
		}
		return JsonResult.fail(1000, "未知错误");
	}
	@RequestMapping("logout")
	public static Object logout(HttpServletResponse response,HttpSession sesssion) {
		sesssion.invalidate();
		return "redirect:/admin/";
	}
}

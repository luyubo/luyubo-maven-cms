package com.luyubo.cms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.commons.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import com.luyubo.cms.common.CmsConstant;
import com.luyubo.cms.common.CmsMd5Util;
import com.luyubo.cms.common.CookieUtil;
import com.luyubo.cms.common.JsonResult;
import com.luyubo.cms.pojo.Article;
import com.luyubo.cms.pojo.Channel;
import com.luyubo.cms.pojo.Comment;
import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.ArticleService;
import com.luyubo.cms.service.CommentService;
import com.luyubo.cms.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CommentService commentService;
	
	/**
	 * 用户登录界面
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public Object login() {
		return "/user/login";
	}
	
	/**
	 * 用户登录接口
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public Object login(User user,HttpSession session,HttpServletResponse response) {
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

		//判断密码
		String string2md5 = CmsMd5Util.string2MD5(user.getPassword());
		if(string2md5.equals(userInfo.getPassword())) {
			session.setAttribute(CmsConstant.UserSessionKey, userInfo);
			if (userInfo.getLocked()==1) {
				return JsonResult.fail(10000, "该用户被禁用");
			}
			return JsonResult.success();
		}
		return JsonResult.fail(1000, "用户名或密码错误");
	}
	
	/**
	 * 退出登录
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public Object logout(HttpServletResponse response,HttpSession session) {
//		User userInfo = (User) session.getAttribute(CmsConstant.UserSessionKey);
		session.removeAttribute(CmsConstant.UserSessionKey);
		CookieUtil.addCookie(response, "username", null, null, null, 0);
		return "redirect:/";
	}
	
	/**
	 * @Title: register   
	 * @Description: 用户注册页面   
	 * @param: @return      
	 * @return: Object      
	 * @throws
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	@ResponseBody
	public Object register(User user,HttpSession session) {
		boolean blank = StringUtil.isBlank(user.getUsername());
		boolean blank1 = StringUtil.isBlank(user.getNickname());
		boolean blank2 = StringUtil.isBlank(user.getPassword());
		boolean blank3 = StringUtil.isBlank(user.getPassword1());
		if(blank==false || blank1==false || blank2==false || blank3==false) {
			return JsonResult.fail(500, "用户名或昵称或密码或确定密码不能为空");
		}
		
		boolean result=userService.isExist(user.getUsername());
		if(result) {
			return JsonResult.fail(10001, "用户名已存在");
		}
		
		if(!user.getPassword().equals(user.getPassword1())) {
			return JsonResult.fail(500, "两次密码不一样");
		}
		boolean flag=userService.register(user);
		if(flag) {
			session.setAttribute(CmsConstant.UserSessionKey, user);
			return JsonResult.success();
		}
		return JsonResult.fail(500,"位置错误");
	}
	
	
	  @RequestMapping(value="register",method=RequestMethod.GET)
	  public  Object register() {
		  return "/user/register"; 
	  }
	 
	
	
	@RequestMapping("center")
	public String center(HttpServletResponse response,HttpSession session) {
		return "user/center";
	}
	
	/**
	 * 设置用户信息
	 */
	@RequestMapping(value = "settings",method = RequestMethod.GET)
	public String settings(HttpServletResponse response,HttpSession session,Model m) {
		User userInfoUser=(User) session.getAttribute(CmsConstant.UserSessionKey);
		User user=userService.getByUsername(userInfoUser.getUsername());
		if(user.getBirthday()!=null) {
			user.setBirthdayStr(new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday()));
		}else {
			user.setBirthdayStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		}
		m.addAttribute("user", user);
		return "user/settings";
	}
	
	/**
	 * 保存用户设置
	 * @param response
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "settings",method = RequestMethod.POST)
	@ResponseBody
	public Object settings(User user,HttpSession session) {
		user.setBirthday(java.sql.Date.valueOf(user.getBirthdayStr()));
		boolean result = userService.update(user);
		if(result) {
			User userInfo = userService.getById(user.getId());
			session.setAttribute(CmsConstant.UserSessionKey, userInfo);
			return JsonResult.success();
		}
		return JsonResult.fail(10002, "修改失败");
	}
	
	@RequestMapping("comment")
	public String comment(Comment comment,Model model,HttpSession session,
			@RequestParam(value="pageNum",defaultValue="1")int pageNum,@RequestParam(value="pageSize",defaultValue="3") int pageSize) {
		//通过session获得user信息
		User userInfo=(User) session.getAttribute(CmsConstant.UserSessionKey);
		comment.setUserId(userInfo.getId());
		
		//根据user的id获得评论表的数据
		PageInfo<Comment> pageInfo=commentService.getByUserId(comment,pageNum,pageSize);
		
		//返回前台
		model.addAttribute("pageInfo", pageInfo);
		return "user/comment";
	}
	
	@RequestMapping("article")
	public String article(Article article,Model model,HttpSession session,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum,@RequestParam(value="pageSize",defaultValue="3") int pageSize) {
		//设置用户Id
		User userInfo = (User)session.getAttribute(CmsConstant.UserSessionKey);
		article.setUserId(userInfo.getId());
		//查询文章
		PageInfo<Article> pageInfo = articleService.getPageInfo(article,pageNum,pageSize);
		model.addAttribute("pageInfo", pageInfo);
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		return "user/article";
	}
	
	@RequestMapping(value = "isLogin")
	@ResponseBody
	public JsonResult isLogin(HttpSession session) {
		User userInfo = (User) session.getAttribute(CmsConstant.UserSessionKey);
		
		if(userInfo==null) {
			return JsonResult.fail(5000, "未登录");
		}
		return JsonResult.success();
	}
	
	@RequestMapping("/tousu")
	public String totousu(Integer articleId,Model model) {
		model.addAttribute("articleId", articleId);
		return "user/tousu";
	}
}

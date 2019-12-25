package com.luyubo.cms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.luyubo.cms.common.CmsConstant;
import com.luyubo.cms.common.JsonResult;
import com.luyubo.cms.pojo.Comment;
import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.CommentService;

/**
 * 评论表控制器
 * @author 77028
 *
 */
@Controller
@RequestMapping("/comment/")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	/**
	 * 添加评论
	 * @param comment
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "add",method =RequestMethod.POST )
	@ResponseBody
	public JsonResult add(Comment comment,HttpSession session) {
		User userInfo=(User) session.getAttribute(CmsConstant.UserSessionKey);
		if(userInfo==null) {
			return JsonResult.fail(CmsConstant.unLoginErrorCode, "用户未登录");
		}
		comment.setUserId(userInfo.getId());
		boolean flag=commentService.add(comment);
		if(flag) {
			return JsonResult.success();
		}
		return JsonResult.fail(1000, "位置错误");
	}
	
	/**
	 * 查询评论和分页
	 * @param articleId
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "list",method =RequestMethod.GET )
	public String getPageInfo(@RequestParam(value="articleId") int articleId,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum,Model model) {
		PageInfo<Comment> pageInfo = commentService.getPageInfo(articleId, pageNum);
		model.addAttribute("pageInfo", pageInfo);
		return "comment/list";
	}
	
	@RequestMapping("delByIds")
	@ResponseBody
	public JsonResult delByIds(String ids) {
		if(ids==null) {
			return JsonResult.fail(5000, "请选择你要删除的文章");
		}
		boolean flag=commentService.delByIds(ids);
		if (flag) {
			return JsonResult.success();
		}
		return JsonResult.fail(5000, "未知错误");
	}
}

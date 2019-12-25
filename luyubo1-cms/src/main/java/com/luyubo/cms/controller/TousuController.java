package com.luyubo.cms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.commons.utils.StringUtil;
import com.luyubo.cms.common.CmsConstant;
import com.luyubo.cms.common.JsonResult;
import com.luyubo.cms.pojo.Complain;
import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.TousuService;
/**
 * 投诉控制器
 * @author 77028
 *
 */
@Controller
@RequestMapping("/tousu/")
public class TousuController {
	@Autowired
	private TousuService tousuService;
	
	@RequestMapping("add")
	@ResponseBody
	public JsonResult add(Complain complain,Integer articleId,HttpSession session) {
		User userInfo = (User) session.getAttribute(CmsConstant.UserSessionKey);
		complain.setUserId(userInfo.getId());
		System.out.println(complain+"============"); 
		System.out.println(StringUtil.isHttpUrl(complain.getUrlip()));
		if(complain.getComplaintype()==null) {
			return JsonResult.fail(5001, "请选择投诉类型");
		}
		if(complain.getUrlip()!=null && !"".equals(complain.getUrlip())) {
			if(!StringUtil.ishttp(complain.getUrlip())) {
				return JsonResult.fail(5000, "请输入正确的http网址");
			}
		}
		boolean add = tousuService.add(complain);
		if(add) {
			return JsonResult.success();
		}
		return JsonResult.fail(5001, "投诉失败");
	}
}

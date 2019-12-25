package com.luyubo.cms.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.luyubo.cms.common.JsonResult;
import com.luyubo.cms.pojo.Link;
import com.luyubo.cms.service.LinkService;

/**
 * 友情链接控制器
 * @author 77028
 *
 */
@Controller
@RequestMapping("/admin/link/")
public class LinkController {
	@Autowired
	private LinkService linkService;
	
	/**
	 * 查询所有连接
	 * @param link
	 * @param model
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Link link,Model model,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum,@RequestParam(value="pageSize",defaultValue="3") int pageSize) {
		PageInfo<Link> pageInfo = linkService.getPageInfo(link, pageNum,pageSize);
		model.addAttribute("pageInfo", pageInfo);
		return "link/list";
	}
	
	/**
	 * 根据id查询并编辑
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "edit",method = RequestMethod.GET)
	public String update(Integer id,Model model) {
		if(id!=null) {
			Link link = linkService.getById(id);
			model.addAttribute("link", link);
		}
		return "link/edit";
	}
	
	/**
	 * 添加友情链接到数据库
	 * @param link
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public JsonResult save(Link link) {
		linkService.save(link);
		return JsonResult.success();
	}
	
	@RequestMapping("delByIds")
	@ResponseBody
	public JsonResult delByIds(String ids) {
		linkService.delByIds(ids);
		return JsonResult.success();
	}
}

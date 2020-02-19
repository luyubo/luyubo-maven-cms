package com.luyubo.cms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.luyubo.cms.common.CmsConstant;
import com.luyubo.cms.common.JsonResult;
import com.luyubo.cms.pojo.Article;
import com.luyubo.cms.pojo.Category;
import com.luyubo.cms.pojo.Channel;
import com.luyubo.cms.pojo.Link;
import com.luyubo.cms.pojo.Slide;
import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.ArticleService;
import com.luyubo.cms.service.LinkService;
import com.luyubo.cms.service.SlideService;
import com.luyubo.cms.util.HLUtils;

/**
 * 文章控制器
 * @author 77028
 *
 */
@Controller
@RequestMapping("/article/")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	@Autowired
	private SlideService slideService;
	@Autowired
	private LinkService LinkService;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//通过es和插件实现高亮查询
	@RequestMapping("/search")
	public String search(String title,Model model,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "5")Integer pageSize) {
		//频道
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		//分类
		List<Slide> slideList=slideService.getAll();
		model.addAttribute("slideList", slideList);
		//最新文章
		List<Article> newArticleList=articleService.getNewList(6);
		model.addAttribute("newArticleList", newArticleList);
		//查询所有友情链接
		List<Link> linkList=LinkService.select();
		model.addAttribute("linkList", linkList);
		
		PageInfo<?> pageInfo = HLUtils.findByHighLight(elasticsearchTemplate, Article.class, page, pageSize, new String[] {"title"}, "id", title);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("title", title);
		return "/index";
	}
	
	/**
	 * 发布文章
	 * @return
	 */
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add(Integer id,Model model) {
		logger.info("articleId:{}",id);
		if(id!=null) {
			Article article = articleService.selectById(id);
			logger.info(article.toString());
			model.addAttribute("article", article);
			List<Category> cateList=articleService.getCateListByChannelId(article.getChannelId());
			model.addAttribute("cateList", cateList);
		}
		List<Channel> channelList=articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		
		return "article/add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult add(Article article,Model model,HttpSession session) {
		System.out.println(article);
		User userInfo = (User)session.getAttribute(CmsConstant.UserSessionKey);
		if(userInfo==null) {
			return JsonResult.fail(CmsConstant.unLoginErrorCode, "未登录");
		}
		article.setUserId(userInfo.getId());
		boolean result = articleService.save(article);
		return JsonResult.success(result);
	}
	
	/**
	 *根据id查询cate表 
	 * @param channelId
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getCateList",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult getCateList(Integer channelId,Model model,HttpSession session) {
		return JsonResult.success(articleService.getCateListByChannelId(channelId));
	}
	
	/**
	 * 修改文章
	 * @return
	 */
	@RequestMapping("update")
	public String update() {
		return "update";
	}
	
	/**
	 * 批量删除
	 * @return
	 */
	@RequestMapping("delByIds")
	@ResponseBody
	public JsonResult delByIds(String ids) {
		if(ids==null) {
			return JsonResult.fail(10001, "请选择删除的文章");
		}
		//已审核判断
		boolean isCheck=articleService.isAllCheck(ids);
		if(!isCheck) {
			return JsonResult.fail(10001, "请选择未审核的文章删除");
		}
		//删除
		boolean result=articleService.delByIds(ids);
		if(result) {
			return JsonResult.success();
		}
		return JsonResult.fail(500, "未知错误");
	}
}

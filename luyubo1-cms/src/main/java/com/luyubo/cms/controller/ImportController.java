package com.luyubo.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.luyubo.cms.pojo.Import;
import com.luyubo.cms.service.ImportService;

@Controller("/import")
public class ImportController {
	@Autowired
	private ImportService importService;
	@RequestMapping("/list")
	public String list(String title,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "5")Integer pageSize,Model model) {
		PageInfo<Import> pageInfo=importService.selectAll(title,page,pageSize);
		model.addAttribute("pageInfo", pageInfo);
		return "user/import";
	}
}

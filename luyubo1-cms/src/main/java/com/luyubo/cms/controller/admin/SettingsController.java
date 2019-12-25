package com.luyubo.cms.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luyubo.cms.common.JsonResult;
import com.luyubo.cms.pojo.Settings;
import com.luyubo.cms.service.SettingsService;

@Controller
@RequestMapping("/admin/")
public class SettingsController {
	@Autowired
	private SettingsService settingsService;
	/**
	 * settings系统设置
	 * @return
	 */
	@RequestMapping("/settings")
	public String settings(Model m) {
		Settings settings = settingsService.get();
		m.addAttribute("settings", settings);
		return "admin/settings";
	}
	
	@RequestMapping("/settings/save")
	@ResponseBody
	public Object save(Model m,Settings settings) {
		boolean flag=settingsService.save(settings);
		if(flag) {
			return JsonResult.success();
		}
		return JsonResult.fail(500, "修改失败");
	}
}

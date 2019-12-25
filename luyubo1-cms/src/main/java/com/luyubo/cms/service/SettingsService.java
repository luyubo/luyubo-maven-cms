package com.luyubo.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Settings的service层
 * @author 77028
 *
 */

import com.luyubo.cms.dao.SettingsDao;
import com.luyubo.cms.pojo.Settings;
@Service
public class SettingsService {
	@Autowired
	private SettingsDao settingsDao;
	
	public Settings get() {
		List<Settings> setList = settingsDao.select(null);
		if(setList==null || setList.size()==0) {
			Settings settings=new Settings();
			settingsDao.insert(settings);
			return settings;
		}
		return setList.get(0);
	}

	/**
	 * 保存系统设置
	 * @param settings
	 * @return
	 */
	public boolean save(Settings settings) {
		Settings set = settingsDao.selectById(settings.getId());
		set.setSite_domain(settings.getSite_domain());
		set.setSite_name(settings.getSite_name());
		int i = settingsDao.update(set);
		return i>0;
	}
}

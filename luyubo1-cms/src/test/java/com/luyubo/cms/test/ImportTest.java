package com.luyubo.cms.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luyubo.StringUtil;
import com.luyubo.cms.pojo.Import;
import com.luyubo.cms.service.ImportService;
/**
 * 三个方法测试
 * @author 77028
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class ImportTest {
	@Autowired
	private ImportService importService;
	@Test
	public void save() {
		Import import1=new Import(null,"随意取得","http://list",190,new Date());
		String substring = import1.getUrl().substring(0, 7);
		System.out.println(substring);
		if(StringUtil.ishttp(substring)) {
			importService.toimport(import1);
			System.out.println("存入成功");
		}
		System.out.println("证明成功");
	}
	//非法url测试
	@Test
	public void saveBadUrl() {
		Import import1=new Import(null,"随意取得","https://list",190,new Date());
		String substring = import1.getUrl().substring(0, 7);
		System.out.println(substring);
		if(StringUtil.ishttp(substring)) {
			importService.toimport(import1);
			System.out.println("存入成功");
		}
		System.out.println("证明失败");
	}
	@Test
	public void delete() {
		Integer id=22;
		importService.delete(id);
	}
	@Test
	public void select() {
		Integer userid=197;
		List<Import> list=importService.select(userid);
		for (Import import1 : list) {
			System.out.println(import1);
		}
	}
}

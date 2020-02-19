package com.luyubo.cms.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luyubo.cms.dao.ArticleRepository;
import com.luyubo.cms.pojo.Article;
import com.luyubo.cms.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class ESTest {
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ArticleService articleService;
	//数据存入es
	@Test
	public void save() {
		Article article=new Article();
		article.setStatus(1);
		List<Article> list=articleService.select(article);
		articleRepository.saveAll(list);
	}
}

package com.luyubo.cms.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.luyubo.cms.pojo.Article;

public interface ArticleRepository extends ElasticsearchRepository<Article, Integer>{
	
}

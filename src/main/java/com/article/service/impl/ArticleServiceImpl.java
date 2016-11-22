package com.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.article.entity.Article;
import com.article.entity.Article.Filter;
import com.article.entity.Article.FormAdd;
import com.article.entity.Article.FormUpdate;
import com.article.repository.ArticleRepository;
import com.article.service.extend.ArticleService;
import com.article.utility.Paging;

@EnableTransactionManagement
@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public List<Article> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findWithPagination(Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findWithFilterAndPagination(Filter filter, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public boolean save(FormAdd article) {
		
		article.setId(articleRepository.nextVal());
		
		if(articleRepository.save(article)){
			return articleRepository.saveImage(article.getId(), article.getImages());
		}
		return false;
	}

	@Override
	public boolean update(FormUpdate article) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean favourite(int articleId, int userId) {
		// TODO Auto-generated method stub
		return false;
	}

}

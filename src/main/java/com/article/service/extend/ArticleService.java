package com.article.service.extend;

import java.util.List;

import com.article.entity.Article;
import com.article.utility.Paging;

public interface ArticleService {
	
	List<Article> findAll();
	
	List<Article> findWithPagination(Paging paging);
		
	List<Article> findWithFilterAndPagination(Article.Filter filter, Paging paging);
	
	Article findById(int id);
	
	boolean remove(int id);
	
	boolean save(Article.FormAdd article);
	
	boolean update(Article.FormUpdate article);
	
	boolean favourite(int articleId, int userId);
	
}

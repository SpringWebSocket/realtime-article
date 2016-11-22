package com.article.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.article.entity.Article;
import com.article.service.extend.ArticleService;
import com.article.utility.Console;

@RestController
@RequestMapping("/api")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="/article", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> saveArticle(@RequestBody Article.FormAdd article){
		Console.log(article);
		
		Map<String, Object> response = new HashMap<>();
		
		if(articleService.save(article)){
			System.out.println("Insert Succed!");
			response.put("status", true);
		}else{
			System.out.println("Insert Failed!");
			response.put("status", false);
		}
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	
	
}

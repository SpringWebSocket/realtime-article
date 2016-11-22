package com.article.service;

import java.util.List;

public interface GlobalService<T> {

	T findOne();

	List<T> findAll();

	boolean save(T object);
	
	boolean delete(Long id);
	
	boolean deleteAll();

	boolean update(T object);
}

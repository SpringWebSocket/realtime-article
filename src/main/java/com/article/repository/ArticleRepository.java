package com.article.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.article.entity.Article;

@Repository
public interface ArticleRepository{
	
	@Insert(SQL.INSERT_IMAGES)
	boolean saveImage(@Param("articleId") int articleId, @Param("images") List<String> images);
	
	//@SelectKey(statement=SQL.SEQUENCE, keyProperty="id", before=true, resultType=int.class)
	@Insert(SQL.INSERT_ARTICLE)
	boolean save(Article.FormAdd article);
	
	//@SelectProvider(method = "findAll", type = ArticleProvider.class)
	@Select(SQL.SELECT_ALL)
	@Results({
		@Result(property = "category.id", column = "categoryId"),
		@Result(property = "category.name", column = "categoryName"),
		@Result(property = "category.icon", column = "categoryIcon"),
		@Result(property = "user.id", column = "userId"),
		@Result(property = "user.name", column = "userName"),
		@Result(property = "user.role", column = "userRole"),
		@Result(property = "user.image", column = "userImage")
	})
	List<Article> findAll();
	
	@Select(SQL.SEQUENCE)
	int nextVal();
	
	interface SQL{
		
		String SEQUENCE = "SELECT nextval('tbarticle_id_seq') AS id";
		
		String SELECT_ALL = ""
				+ "	SELECT"
				+ "		A .ID,"
				+ "		A .title,	"
				+ "		A .description,"
				+ "		A .CONTENT,"
				+ "		A .thumbnail,"
				+ "		C .ID AS \"categoryId\","
				+ "		C .NAME AS \"categoryName\","
				+ "		C .ICON AS \"categoryIcon\","
				+ "		U .ID AS \"userId\","
				+ "		U .NAME AS userName,"
				+ "		U .image \"userImage\","
				+ "		U .ROLE \"userRole\""
				+ "	FROM	"
				+ "		tbarticle A"
				+ "	LEFT JOIN tbcategory C "
				+ "		ON C . ID = A .category_id"
				+ "	LEFT JOIN tbuser U "
				+ "		ON U. ID = A .user_id"
				+ "	ORDER BY "
				+ "		A.id DESC";
		
		String SELECT_BY_PAGINATION = ""
				+ "	";
		
		String INSERT_IMAGES = ""
				+ "<script>"
				+ "		INSERT INTO tbimage(article_id, image) VALUES"
				+ "		<foreach collection='images' item='image' separator=','>"
				+ "			(#{articleId}, #{image})"	
				+ "		</foreach>"
				+ "</script>";
		
		String INSERT_ARTICLE = ""
				+ "	INSERT INTO tbarticle("
				+ "		id,"
				+ "		title,"
				+ "		description,"
				+ "		content,"
				+ "		thumbnail,"
				+ "		category_id,"
				+ "		user_id	"
				+ "	)"
				+ "	VALUES("
				+ "		#{id},"
				+ "		#{title},"
				+ "		#{description},"
				+ "		#{content},"
				+ "		#{thumbnail},"
				+ "		#{category.id},"
				+ "		#{user.id}"
				+ "	)";
	}
	
}

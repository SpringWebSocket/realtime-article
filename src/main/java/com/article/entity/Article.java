package com.article.entity;

import java.util.List;

public class Article {
	
	public static class Filter{
		private String title;
		private String category;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		@Override
		public String toString() {
			return "Filter [title=" + title + ", category=" + category + "]";
		}
	}
	
	public static class FormAdd{
		private int id;
		private String title;
		private String thumbnail;
		private String description;
		private String content;
		private List<String> images;
		private Category category;
		private User user;

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getThumbnail() {
			return thumbnail;
		}
		public void setThumbnail(String thumbnail) {
			this.thumbnail = thumbnail;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public List<String> getImages() {
			return images;
		}
		public void setImages(List<String> images) {
			this.images = images;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		@Override
		public String toString() {
			return "FormAdd [title=" + title + ", thumbnail=" + thumbnail + ", description=" + description
					+ ", content=" + content + ", images=" + images + ", category=" + category + ", user=" + user + "]";
		}
	}
	
	public static class FormUpdate extends FormAdd{
		
	}
	
}

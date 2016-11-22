package com.article.entity;

public class User {
	private int id;
	private String name;
	private String image;
	private String role;
	
	public User(){}
	public User(String name){
		this.name = name;
	}
	public User(int id, String name){
		this(name);
		this.id = id;
	}
	public User(int id, String name, String image){
		this(id, name);
		this.image = image;
	}
	public User(int id, String name, String image, String role){
		this(id, name, image);
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", image=" + image + ", role=" + role + "]";
	}
}

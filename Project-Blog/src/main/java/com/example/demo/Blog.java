package com.example.demo;

public class Blog {
	
	private String aname;
	private String title;
	private String content;
	private String id;
	
	public Blog(String id,String aname, String title, String content) {
		super();
		this.id=id;
		this.aname = aname;
		this.title = title;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	

}

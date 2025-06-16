package com.frigildo.workshopmongo.dto;

import java.io.Serializable;

import com.frigildo.workshopmongo.domain.User;

public class Author implements Serializable {

	private String id;
	private String name;

	public Author() {
		super();
	}

	public Author(User obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

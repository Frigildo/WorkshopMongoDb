package com.frigildo.workshopmongo.dto;

import java.io.Serializable;
import java.time.Instant;

public class CommentDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String text;
	private Instant date;
	private Author author;

	public CommentDto() {
	}

	public CommentDto(String text, Instant date, Author author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}

package models;

import java.io.Serializable;

public class Book implements Serializable {
	private long id;

	private String title;

	private String author;

	public Book() {
	}

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public Book(long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
package com.epam.library.domain;

public class Book {

	private int id;
	
	private String author;
	
	private String title;
	
	private int publishYear;
	
	public Book(String author, String title, int publishYear) {
		this.id = 0;
		this.author = author;
		this.title = title;
		this.publishYear = publishYear;
	}
	
	public Book(int id, String author, String title, int publishYear) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.publishYear = publishYear;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + publishYear;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (publishYear != other.publishYear)
			return false;
		return true;
	}
}

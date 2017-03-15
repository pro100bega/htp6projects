package com.epam.library.util;

public class DBQueries {
	
	public static final String ADD_BOOK = 
			"insert into book(author, title, publish_year) values(?,?,?)";
	public static final String GET_ALL_BOOKS = 
			"select * from book";
	public static final String UPDATE_BOOK_AUTHOR_BY_ID = 
			"update book set author=? where id=?";
	public static final String UPDATE_BOOK_TITLE_BY_ID =
			"update book set title=? where id=?";
	public static final String UPDATE_BOOK_PUBLISH_YEAR_BY_ID = 
			"update book set publish_year=? where id=?";
	public static final String DELETE_BOOK_BY_ID = 
			"delete from book where id=?";
}

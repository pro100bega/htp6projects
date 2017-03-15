package com.epam.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

import com.epam.library.dao.exception.DAOException;
import com.epam.library.domain.Book;
import com.epam.library.util.DBQueries;

import static com.epam.library.util.DBConstants.*;

public class DAORead {
	public List<Book> getAllBooks() throws DAOException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Book> books = Collections.emptyList();
		
		try {
			connection = DriverManager.getConnection(CONNECTION_STRING, 
					USERNAME, P_WORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(DBQueries.GET_ALL_BOOKS);
			
			while (resultSet.next()) {
				Book book = new Book(
						resultSet.getInt("id"),
						resultSet.getString("author"),
						resultSet.getString("author"),
						resultSet.getInt("publish_year"));
				
				books.add(book);
			}
			
			return books;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

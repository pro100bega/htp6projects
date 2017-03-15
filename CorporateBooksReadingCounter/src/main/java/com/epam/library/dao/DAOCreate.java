package com.epam.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.epam.library.dao.exception.DAOException;
import com.epam.library.domain.Book;
import com.epam.library.util.DBQueries;

import static com.epam.library.util.DBConstants.*;

public class DAOCreate {
	
	public void addBook(Book book) throws DAOException {
		//TODO
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME,
					P_WORD);
			preparedStatement = connection.prepareStatement(DBQueries.ADD_BOOK);
			
			preparedStatement.setString(1, book.getAuthor());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setInt(3, book.getPublishYear());
			
			preparedStatement.executeUpdate();
			
			
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

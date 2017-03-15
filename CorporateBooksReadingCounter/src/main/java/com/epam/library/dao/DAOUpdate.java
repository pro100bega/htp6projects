package com.epam.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.epam.library.dao.exception.DAOException;
import com.epam.library.util.DBQueries;

import static com.epam.library.util.DBConstants.*;

public class DAOUpdate {
	public void updateBookAuthorById(String author, int id)
			throws DAOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, P_WORD);
			preparedStatement = connection.prepareStatement(
					DBQueries.UPDATE_BOOK_AUTHOR_BY_ID);
			preparedStatement.setString(1, author);
			preparedStatement.setInt(2, id);
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
	
	public void updateBookTitleById(String title, int id)
			throws DAOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, P_WORD);
			preparedStatement = connection.prepareStatement(
					DBQueries.UPDATE_BOOK_TITLE_BY_ID);
			preparedStatement.setString(1, title);
			preparedStatement.setInt(2, id);
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
	
	public void updateBookPublishYearById(int publishYear, int id)
			throws DAOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, P_WORD);
			preparedStatement = connection.prepareStatement(
					DBQueries.UPDATE_BOOK_PUBLISH_YEAR_BY_ID);
			preparedStatement.setInt(1, publishYear);
			preparedStatement.setInt(2, id);
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

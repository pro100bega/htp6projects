package com.epam.library.controller;

import java.util.Scanner;

import com.epam.library.dao.DAOCreate;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.domain.Book;
import com.epam.library.util.DBConstants;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = null;
		
		try {
			Class.forName(DBConstants.DRIVER_NAME);

			scanner = new Scanner(System.in);

			System.out.println("Enter book author:");
			String author = scanner.nextLine();

			System.out.println("Enter book title:");
			String title = scanner.nextLine();

			System.out.println("Enter book published year:");
			int publishYear = Integer.parseInt(scanner.nextLine());

			Book book = new Book(author, title, publishYear);

			DAOCreate daoCreate = new DAOCreate();

			daoCreate.addBook(book);
			
			System.out.println("Book was successfully added!");
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}

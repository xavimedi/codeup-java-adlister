package dao;

import java.awt.print.Book;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;
import java.util.ArrayList;
import java.util.List;

public class MySQLBooksDao{
	private Connection connection = null;

	public MySQLBooksDao(BookConfig config) {
		try {
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection(
					config.getUrl(),
					config.getUser(),
					config.getPassword()
			);
		} catch (SQLException e) {
			throw new RuntimeException("error connecting to database", e);
		}
	}

//	public static void main(String[] args) {
//		dao.BookConfig config = new dao.BookConfig();
//		dao.MySQLBooksDao booksDao = new dao.MySQLBooksDao(config);
//		models.Book dracula = new models.Book("Dracula", "Bram Stoker");
//		long result = booksDao.insert(dracula);
//		System.out.println(result);
//	}

//	@Override
//	public long insert(models.Book book) {
//		return 0;
//	}

//	@Override
//	public long insert(models.Book book) {
//		try {
//			Statement stmt = connection.createStatement();
//			long result = stmt.executeUpdate("INSERT INTO books_example.books (title, author) VALUES ('" + book.getTitle() + "', '" + book.getAuthor() + "')");
//			return result;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
}
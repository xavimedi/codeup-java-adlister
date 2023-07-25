package dao;

public class BookConfig {
	public String getUrl() {
		return "jdbc:mysql://localhost:3306/books_example?allowPublicKeyRetrieval=true&useSSL=false";
	}
	public String getUser() {
		return "root";
	}
	public String getPassword() {
		return "codeup";
	}
}
package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import dao.Config;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {

	private static Connection connection;

	public static void main(String[] args) {
		Config config = new Config();
		String url = config.getUrl();
		String user = config.getUser();
		String password = config.getPassword();

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			MySQLUsersDao usersDao = new MySQLUsersDao(connection);
			List<User> users = usersDao.getAllUsers();
			System.out.println("List of all users:");
			for (User u : users) {
				System.out.println(u);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public MySQLUsersDao(Connection connection) {
		this.connection = connection;
	}

	public MySQLUsersDao(Config config) {
		try {
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection(
					config.getUrl(),
					config.getUser(),
					config.getPassword()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Error connecting to the database!", e);
		}
	}

	@Override
	public User findByUsername(String username) {
		String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, username);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return extractUser(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long insert(User user) {
		String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());

			int affectedRows = stmt.executeUpdate();
			if (affectedRows == 0) {
				return null;
			}

			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getLong(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User createUser(User user) {

		if (connection == null) {
			System.err.println("Error: Database connection is null.");
			return null;
		}

		String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());

			int affectedRows = stmt.executeUpdate();
			if (affectedRows == 0) {
				System.err.println("Error: User creation failed, no rows affected.");
				return null;
			}

			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					user.setId(generatedKeys.getLong(1));
				} else {
					System.err.println("Error: User creation failed, no ID obtained.");
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}

	@Override
	public User getUserByID(long id) {
		String query = "SELECT * FROM users WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setLong(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return extractUser(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, username);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return extractUser(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM users";
		try (Statement stmt = connection.createStatement();
			 ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				users.add(extractUser(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}


	@Override
	public void updateUser(User user) {
		String query = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setLong(4, user.getId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(long id) {
		String query = "DELETE FROM users WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private User extractUser(ResultSet rs) throws SQLException {
		long id = rs.getLong("id");
		String username = rs.getString("username");
		String email = rs.getString("email");
		String password = rs.getString("password");
		return new User(id, username, email, password);
	}
}

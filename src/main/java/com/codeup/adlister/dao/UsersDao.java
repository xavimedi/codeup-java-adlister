package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface UsersDao {

	User findByUsername(String username);

	Long insert(User user);

	User createUser(User user);

	User getUserByID(long id);

	User getUserByUsername(String username);

	List<User> getAllUsers();

	void updateUser(User user);

	void deleteUser(long id);
}

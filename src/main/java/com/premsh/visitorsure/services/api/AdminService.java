package com.premsh.visitorsure.services.api;

import java.util.List;

import com.premsh.visitorsure.models.User;

public interface AdminService extends UserService, VerifierServices{
	
	List<User> listUsers();
	List<User> getUserbyId(Integer id);
	boolean updateUserDetails(User user, Integer id);
	boolean deleteUser(Integer userId);
	boolean createUser(User user);
	
}

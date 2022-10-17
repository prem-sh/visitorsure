package com.premsh.visitorsure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.premsh.visitorsure.models.User;
import com.premsh.visitorsure.repository.UserDao;
import com.premsh.visitorsure.services.api.AdminService;

@Service
public class AdminServiceImpl extends UserServiceImpl implements  AdminService {
	@Autowired
	UserDao userDao;

	public List<User> listUsers() {
		return userDao.getAllUsers();
	}
	public List<User> getUserbyId(Integer id) {
		return userDao.getUser(id);
	}

	public boolean updateUserDetails(User user, Integer id) {
		return userDao.updateUser(user, id);
	}

	public boolean deleteUser(Integer userId) {
		return userDao.deleteUser(userId);
	}

	public boolean createUser(User user) {
		return userDao.createUser(user);
	}

}

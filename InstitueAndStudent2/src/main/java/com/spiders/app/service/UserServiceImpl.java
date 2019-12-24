package com.spiders.app.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiders.app.dao.UserDaoI;
import com.spiders.app.dto.UserDto;


@Service
public class UserServiceImpl implements UserServiceI {
	
	@Autowired
	UserDaoI dao;
	
	@Override
	public Serializable saveUser(UserDto user) {
		return dao.saveUser(user);
	}

	@Override
	public void updateUser(UserDto user) {
		dao.updateUser(user);
	}

	@Override
	public void delete(UserDto user) {
		dao.delete(user);
	}

	@Override
	public UserDto findUser(String loginId) {
		return dao.findUser(loginId);
	}

	@Override
	public UserDto findUser(long userId) {
		return dao.findUser(userId);
	}

	@Override
	public List<UserDto> findAllUserByAdminId(long AdminId) {
		return dao.findAllUserByAdminId(AdminId);
	}
	

}

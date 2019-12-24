package com.spiders.app.dao;

import java.io.Serializable;
import java.util.List;

import com.spiders.app.dto.UserDto;

public interface UserDaoI {

	
	public Serializable saveUser(UserDto user);
	public void  updateUser(UserDto user);
	public void delete(UserDto user);
	public UserDto findUser(String loginId);
	public UserDto findUser(long userId);
	public List<UserDto> findAllUserByAdminId(long adminId);
	
}

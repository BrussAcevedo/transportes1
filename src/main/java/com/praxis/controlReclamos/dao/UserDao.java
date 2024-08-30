package com.praxis.controlReclamos.dao;

import java.util.List;
import com.praxis.controlReclamos.entity.UserEntity;

public interface UserDao {

	List<UserEntity>findall();
	UserEntity findById(Integer userId);
	void save(UserEntity user);
	void deleteByID(Integer userID);
	Boolean existById(Integer userId);
	
}

package com.praxis.controlReclamos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.praxis.controlReclamos.entity.UserEntity;
import com.praxis.controlReclamos.repository.UserRepository;

@Component
public class UserDaoImp implements UserDao{
	
	@Autowired
	UserRepository userRepo;
	
	
	@Override
	public List<UserEntity> findall() {
		return (List<UserEntity>) userRepo.findAll();
	}

	@Override
	public UserEntity findById(Integer userId) {
		
		return userRepo.findById(userId).orElse(new UserEntity());
	}

	@Override
	public void save(UserEntity user) {
		userRepo.save(user);
	}

	@Override
	public void deleteByID(Integer userID) {
		userRepo.deleteById(userID);
	}

	@Override
	public Boolean existById(Integer userId) {
		if (userRepo.existsById(userId)) {
			return true;
		}
		return false;
	}

	
	
}

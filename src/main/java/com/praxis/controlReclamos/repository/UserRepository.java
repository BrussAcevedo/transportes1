package com.praxis.controlReclamos.repository;

import org.springframework.data.repository.CrudRepository;
import com.praxis.controlReclamos.entity.UserEntity;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<UserEntity, Integer>{

		Optional<UserEntity> findByUserMail(String userMail);
	
	
}

package com.praxis.controlReclamos.dao;

import java.util.List;
import com.praxis.controlReclamos.entity.RoleEntity;

public interface RoleDao {

	
	List<RoleEntity>findall();
	RoleEntity findById(Integer roleID);
	void save(RoleEntity role);
	void deleteByID(Integer roleID);
	Boolean existById(Integer roleId);
	
}

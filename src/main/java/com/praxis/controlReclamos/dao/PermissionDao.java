package com.praxis.controlReclamos.dao;

import java.util.List;
import com.praxis.controlReclamos.entity.PermissionEntity;

public interface PermissionDao {

	
	List<PermissionEntity>findall();
	PermissionEntity findById(Integer permissionID);
	void save(PermissionEntity permission);
	void deleteByID(Integer permissionID);
	Boolean existById(Integer permissionId);
	
}

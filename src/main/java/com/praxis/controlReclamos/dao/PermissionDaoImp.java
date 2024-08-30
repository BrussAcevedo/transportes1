package com.praxis.controlReclamos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.praxis.controlReclamos.entity.PermissionEntity;
import com.praxis.controlReclamos.repository.PermissionRepository;

@Component
public class PermissionDaoImp implements PermissionDao{

	@Autowired
	PermissionRepository permissionRepo;
	
	@Override
	public List<PermissionEntity> findall() {
		return (List<PermissionEntity>) permissionRepo.findAll();
	}

	@Override
	public PermissionEntity findById(Integer permissionID) {
		return permissionRepo.findById(permissionID).orElse(new PermissionEntity());
	}

	@Override
	public void save(PermissionEntity permission) {
		permissionRepo.save(permission);
	}

	@Override
	public void deleteByID(Integer permissionID) {
		permissionRepo.deleteById(permissionID);
		
	}

	@Override
	public Boolean existById(Integer permissionId) {
		if (permissionRepo.existsById(permissionId)) {
			return true;
		}
		return false;
	}

	
	
	
}

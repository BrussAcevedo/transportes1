package com.praxis.controlReclamos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.praxis.controlReclamos.entity.RoleEntity;
import com.praxis.controlReclamos.repository.RoleRepository;

@Component
public class RoleDaoImp implements RoleDao{
	
	
	@Autowired
	RoleRepository roleRepo;

	@Override
	public List<RoleEntity> findall() {
		
		return (List<RoleEntity>) roleRepo.findAll();
	}

	@Override
	public RoleEntity findById(Integer roleID) {
		
		return roleRepo.findById(roleID).orElse(new RoleEntity());
	}

	@Override
	public void save(RoleEntity role) {
		roleRepo.save(role);
	}

	@Override
	public void deleteByID(Integer roleID) {
		roleRepo.deleteById(roleID);
	}

	@Override
	public Boolean existById(Integer roleId) {
		if (roleRepo.existsById(roleId)) {
			return true;
		}
		return false;
	}

}

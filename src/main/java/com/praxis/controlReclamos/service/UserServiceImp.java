package com.praxis.controlReclamos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praxis.controlReclamos.controller.dto.PermissionDTO;
import com.praxis.controlReclamos.controller.dto.RoleDTO;
import com.praxis.controlReclamos.controller.dto.UserDTO;
import com.praxis.controlReclamos.dao.UserDaoImp;
import com.praxis.controlReclamos.entity.UserEntity;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserDaoImp userDao;
	
	@Override
	public List<UserDTO> findAll() {
		
		List<UserEntity> usersEntList = userDao.findall();
		List<UserDTO> usersDtoList = usersEntList.stream().map((userTemp) -> {
			return UserDTO.builder()
					.userId(userTemp.getUserId())
					.userMail(userTemp.getUserMail())
					.userName(userTemp.getUserName())
					.userLastName(userTemp.getUserLastName())
					.userRut(userTemp.getUserRut())
					.roles(userTemp.getRoles().stream().map((rolTemp)->{
						return RoleDTO.builder()
								.rolId(rolTemp.getRolId())
								.rolName(rolTemp.getRolName())
								.permisos(rolTemp.getPermissions().stream().map((permissionTemp)->{
									return PermissionDTO.builder()
											.permissionId(permissionTemp.getPermissionId())
											.permissionName(permissionTemp.getPermissionName())
											.build();
								}).toList())
								.build();					
					}).toList())
					.build();
		}).toList();
			
		return usersDtoList;
	}

	@Override
	public UserDTO findById(Integer idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(UserDTO user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByID(Integer idUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existById(Integer idUser) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
}

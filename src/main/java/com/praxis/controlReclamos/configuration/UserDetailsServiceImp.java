package com.praxis.controlReclamos.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.praxis.controlReclamos.entity.UserEntity;
import com.praxis.controlReclamos.repository.UserRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepo.findByUserMail(userMail)
				.orElseThrow(()-> new UsernameNotFoundException (String.format("El usuario No Existe", userMail)));
			
		List<SimpleGrantedAuthority> authorities = new  ArrayList<SimpleGrantedAuthority>();
		
		userEntity.getRoles().forEach((roleTemp)->{
			authorities.add(new SimpleGrantedAuthority("ROLE_".concat(roleTemp.getRolName().toString())));});
		
		
		userEntity.getRoles().stream().flatMap(role -> role.getPermissions().stream())
						.forEach(permissions -> authorities.add(new SimpleGrantedAuthority(permissions.getPermissionName().toString())));;

		return new User(userEntity.getUserMail(), userEntity.getUserPassword(), authorities);
		
	}

}
 
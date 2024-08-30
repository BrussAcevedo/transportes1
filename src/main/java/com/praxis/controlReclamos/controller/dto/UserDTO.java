package com.praxis.controlReclamos.controller.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserDTO {

	private Integer userId;
	private String userMail;
	private String userPassword;
	private String userName;
	private String userLastName;
	private String userRut;
	
	private List<RoleDTO> roles;


	
	
}

package com.praxis.controlReclamos.controller.dto;

import java.util.List;
import com.praxis.controlReclamos.entity.RolEnum;
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
public class RoleDTO {

	private Integer rolId;
	private RolEnum rolName;

	List<PermissionDTO> permisos;

	
}

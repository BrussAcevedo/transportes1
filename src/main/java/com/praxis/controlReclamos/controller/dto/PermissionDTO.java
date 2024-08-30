package com.praxis.controlReclamos.controller.dto;

import com.praxis.controlReclamos.entity.PermissionEnum;
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
public class PermissionDTO {

	private Integer permissionId;
	private PermissionEnum permissionName;
		
}

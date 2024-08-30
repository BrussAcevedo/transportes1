package com.praxis.controlReclamos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="permissions")
public class PermissionEntity {

	@Id
	@Column(name ="permission_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer permissionId;
	
	@Column(name ="permission_name")
	@Enumerated(EnumType.STRING)
	private PermissionEnum permissionName;
		
}

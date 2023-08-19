package com.sara.rsp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

	public int getRoleId() {
		return id;
	}

	public void setRoleId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return name;
	}

	public void setRoleName(String name) {
		this.name = name;
	}
    
}


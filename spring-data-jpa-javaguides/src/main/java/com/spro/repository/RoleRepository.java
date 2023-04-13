package com.spro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spro.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByName(String name);

}

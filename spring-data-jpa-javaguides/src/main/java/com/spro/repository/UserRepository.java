package com.spro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spro.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

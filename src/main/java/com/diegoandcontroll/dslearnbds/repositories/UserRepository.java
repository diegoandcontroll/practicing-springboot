package com.diegoandcontroll.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegoandcontroll.dslearnbds.domain.User;



public interface UserRepository extends JpaRepository<User,Long> {

	User findByEmail(String email);
}

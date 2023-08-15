package com.vinh.fresherApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinh.fresherApp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	Optional<User> findByUsernameOrEmail(String userName,String email);
	Optional<User> findByUsername(String userName);
	
	Boolean existsByUsername(String username);
	Boolean existsByemail(String username);
}

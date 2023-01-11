package com.example.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long>{

	
//	@Query("SELECT username FROM users WHERE username = :username")
//	UserAccount findByUsername(String username);

}

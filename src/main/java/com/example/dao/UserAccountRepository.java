package com.example.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.entities.UserAccount;

@RepositoryRestResource(collectionResourceRel = "apiusers", path = "apiusers")
public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long>{

	
//	@Query("SELECT username FROM users WHERE username = :username")
//	UserAccount findByUsername(String username);

}

package com.fauv.authenticator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fauv.authenticator.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByVwId(String vwId);
	
}

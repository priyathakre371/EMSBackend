package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
	
	
	
	
	// "select e from Employee e where e.username = :username and e.password = :password"

	//@Query("select e from Registration e where e.username = :username and e.password = :password")
	//public Registration findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
	public Registration findByUsernameAndPassword(String username, String password);
	public Registration findByEmailAndPassword(String email, String password);
}


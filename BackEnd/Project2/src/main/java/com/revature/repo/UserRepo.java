package com.revature.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Page;
import com.revature.beans.User;

@Repository("userRepo")
public interface UserRepo extends CrudRepository<User, Integer>{
	
	
	Optional<User> findByUsernameAndPassword(String username, String password);

	

}

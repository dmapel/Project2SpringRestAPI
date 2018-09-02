package com.revatue.Project2.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revatue.Project2.beans.Page;
import com.revatue.Project2.beans.User;

@Repository("userRepo")
public interface UserRepo extends CrudRepository<User, Integer>{
	
	
	Optional<User> findByUsernameAndPassword(String username, String password);

	

}

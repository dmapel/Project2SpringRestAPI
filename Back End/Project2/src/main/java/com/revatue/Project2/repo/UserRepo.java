package com.revatue.Project2.repo;

import org.springframework.data.repository.CrudRepository;

import com.revatue.Project2.beans.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	
	//Dont know what this does...
}

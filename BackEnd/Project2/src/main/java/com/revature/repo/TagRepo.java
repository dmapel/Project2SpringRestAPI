package com.revature.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Tag;

@Repository("tagRepo")
public interface TagRepo extends CrudRepository<Tag, Integer>{

}

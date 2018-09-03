package com.revatue.Project2.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revatue.Project2.beans.Tag;

@Repository("tagRepo")
public interface TagRepo extends CrudRepository<Tag, Integer>{

}

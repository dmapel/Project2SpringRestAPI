package com.revatue.Project2.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.revatue.Project2.beans.Page;

@Repository("pageRepo")
public interface PageRepo extends PagingAndSortingRepository<Page, Integer>{

}

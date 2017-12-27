package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Category;
import com.how2java.pojo.Page;

public interface CategoryService {

	List<Category> list();
	
	int add(Category category);
	
	int total();
	
    List<Category> list(Page page);
    
    void delete(int id);
    
    Category get(int id);
    
    int update(Category category);
    
}

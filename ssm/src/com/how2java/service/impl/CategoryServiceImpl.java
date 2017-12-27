package com.how2java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.pojo.Page;
import com.how2java.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{
	
	@Autowired
	CategoryMapper categoryMapper;
	
	public List<Category> list(){
		
		return categoryMapper.list();
	};
	
	public int add(Category category){
		
		return categoryMapper.add(category);
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return categoryMapper.total();
	}

	@Override
	public List<Category> list(Page page) {
		// TODO Auto-generated method stub
		return categoryMapper.list(page);
	}

	@Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.get(id);
	}

	@Override
	public int update(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.update(category);
	}
}
































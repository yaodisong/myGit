package com.how2java.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("/Category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/list")
	public ModelAndView listCategory(HttpServletRequest request, Model model){
		
		ModelAndView mav = new ModelAndView();
		List<Category> cs = categoryService.list();
		if(cs!=null){
			// 放入转发参数
			mav.addObject("cs", cs);
			// 放入jsp路径
			mav.setViewName("listCategory");		
		}else{
			System.out.println("error!");
		}
		return mav;
		
	}
	
	@RequestMapping("/addCategory")
	public ModelAndView addCategory(HttpServletRequest request, Model model){
		
		ModelAndView mav = new ModelAndView();
		List<Category> cs = categoryService.list();
		Category category = new Category();
		category.setName("测试1");
		int num = categoryService.add(category);
		if(num!=0){
			cs.add(category);
			// 放入转发参数
			mav.addObject("cs", cs);
			// 放入jsp路径
			mav.setViewName("listCategory");
		}else{
			System.out.println("error!");
		}
		return mav;
		
	}

}




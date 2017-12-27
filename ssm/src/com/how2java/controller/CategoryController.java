package com.how2java.controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.pojo.Category;
import com.how2java.pojo.Page;
import com.how2java.pojo.UploadedImageFile;
import com.how2java.service.CategoryService;
import com.how2java.util.ImageUtil;
import com.how2java.util.MsgForAjax;
import com.how2java.util.StringUtil;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("/Category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	/**
	 * 有分页的界面
	 * @param page 分页信息
	 * @return
	 */
	@RequestMapping("/listCategory")
    public String listCategory(Model model,Page page){
	
        List<Category> cs = categoryService.list(page);
        int total = categoryService.total();
         
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "listCategory";
        
    }
	
	/**
	 * 分类管理页面添加接口
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/admin_category_add")
	public Map<String, Object> add(HttpServletRequest request,HttpServletResponse response){
		//设置响应头
		response.setHeader("Access-Control-Allow-Origin", "*");
	    //告诉浏览器编码方式  
		response.setHeader("Content-Type","text/html;charset=UTF-8" ); 
		String categoryName = request.getParameter("categoryName");
		Category c = new Category();
		c.setName(categoryName);
	    categoryService.add(c);
	    return MsgForAjax.sendSuccMsg("添加成功！");
	}
	
	/**
	 * 分类管理页面删除接口
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/admin_category_delete")
    public Map<String, Object> delete(HttpServletRequest request,HttpServletResponse response){
       
		//设置响应头
		response.setHeader("Access-Control-Allow-Origin", "*");
	    //告诉浏览器编码方式  
		response.setHeader("Content-Type","text/html;charset=UTF-8" ); 
		int id = Integer.parseInt(request.getParameter("id"));
		categoryService.delete(id);
		return MsgForAjax.sendSuccMsg("删除成功！");
    }
	
	/**
	 * 分类管理页面编辑接口（跳转到编辑页面）
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin_category_edit")
    public String turnToEdit(HttpServletRequest request,Model model){
	
       int id = Integer.parseInt(request.getParameter("id"));
       model.addAttribute("id",id);
       return "categoryEdit";
        
    }
	
	/**
	 * 获取当前所编辑对象数据
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/admin_category_editList")
    public Map<String, Object> list(HttpServletRequest request,HttpServletResponse response){
       
		//设置响应头
		response.setHeader("Access-Control-Allow-Origin", "*");
	    //告诉浏览器编码方式  
		response.setHeader("Content-Type","text/html;charset=UTF-8" ); 
		int id = StringUtil.toInt(request.getParameter("id"), true);
		Category category = categoryService.get(id);
		return MsgForAjax.sendSuccData(category);
    }
	
	@ResponseBody
	@RequestMapping("/admin_category_update")
    public Map<String, Object> update(HttpServletRequest request,HttpServletResponse response) throws IOException{
       
		//设置响应头
		response.setHeader("Access-Control-Allow-Origin", "*");
	    //告诉浏览器编码方式  
		response.setHeader("Content-Type","text/html;charset=UTF-8" ); 
		int id = StringUtil.toInt(request.getParameter("id"), true);
		String name = request.getParameter("name");
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		int num = categoryService.update(category);
		if(num!=0){
//			response.sendRedirect("apage.jsp");
			return MsgForAjax.sendSuccMsg("修改成功！");
		}else
		return MsgForAjax.sendFailMsg("修改失败！");
    }
	
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
	

}




package com.how2java.mapper;
 
import java.util.List;

import com.how2java.pojo.Category;
 
public interface CategoryMapper {
 
    /**
     * 新增  
     * @param category
     * @return
     */
    public int add(Category category);  
       
    /**
     * 删除  
     * @param id
     */
    public void delete(int id);  
       
    /**
     * 通过id查询  
     * @param id
     * @return
     */
    public Category get(int id);  
     
    /**
     * 修改  
     * @param category
     * @return
     */
    public int update(Category category);   
       
    /**
     * 查询全部  
     * @return
     */
    public List<Category> list();
    
    /**
     *   
     * @return
     */
    public int count();  
    
    
    
}
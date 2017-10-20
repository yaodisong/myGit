package com.how2java.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.pojo.User;

/**
 * 设置浏览器路径拦截
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor{
	
	//执行Handler完成执行此方法
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion");
	}
	
	//返回modelAndView之前执行
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");
		response.sendRedirect("/index.jsp");  
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		//首先进入的方法
        System.out.println("preHandle");
        //return false表示拦截，不向下执行
         //return true表示放行
        System.out.println(request.getServletPath());
        HttpSession session = request.getSession();
        User u=(User)session.getAttribute("user");
        if(u!=null){
            return true;
        }else{
        	request.getRequestDispatcher("WebContent/WEB-INF/jsp/index.jsp").forward(request, response);
//            return false; 
        }
        return false;
	}

}








































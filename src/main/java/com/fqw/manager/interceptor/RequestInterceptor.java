package com.fqw.manager.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object obj) throws Exception {
//		 httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");  
//		  
//	        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
//	  
//	        httpServletResponse.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
//	  
//	        httpServletResponse.setHeader("X-Powered-By","Jetty");  
//	  
//	  
//	        String method= httpServletRequest.getMethod();  
//	        if (method.equals("OPTIONS")){  
//	            httpServletResponse.setStatus(200);  
//	            return false;  
//	        }  
//	  
//	        System.out.println(method);  
	  System.out.println("==========123=========");
	        return true;  
	}

}

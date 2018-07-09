package cn.nc.crm.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet  extends HttpServlet {
	 
     /*
        /LoginServlet_方法.do
     */  
	 @Override
	 public void doGet(HttpServletRequest request
			 ,HttpServletResponse response) 
					 throws ServletException, IOException{
		 String URI = request.getRequestURI();
		 // /LoginServlet_login.do
		 int _str =URI.indexOf("_");
		 int str = URI.indexOf(".");
		 String className = URI.substring(1,_str);
		 String methodName =URI.substring(_str+1,str);
		 try {
			 Class clazz =Class.forName("cn.nc.crm.controller."+className);
			 Object obj  = clazz.newInstance();
			 Method method = clazz.getMethod(methodName,
					 HttpServletRequest.class,
					 HttpServletResponse.class);
			 method.invoke(obj,request,response);
		} catch (Exception e) {
			 e.printStackTrace();
		}

	 }
	 @Override 
	 public void doPost(HttpServletRequest request
			 ,HttpServletResponse response) 
					 throws ServletException, IOException{
		    this.doGet(request, response);
	 }
	
	
}

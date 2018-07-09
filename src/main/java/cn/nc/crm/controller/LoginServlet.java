package cn.nc.crm.controller;


import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.nc.crm.bean.User;
import cn.nc.crm.user.service.UserService;
import cn.nc.crm.user.service.impl.UserServiceImpl;
import cn.nc.crm.utils.BeanUtils;

public class LoginServlet extends ControllerServlet {
	
	 private UserService userService = new UserServiceImpl();
	 
	 public void login(HttpServletRequest request
			 ,HttpServletResponse response) 
					 throws ServletException, IOException{
		  //request可以从客户端拿取数据
		  // java.beans.PropertyDescriptor;
		  //构造器有两参数,第一个参数为你需要复制的变量,第二个参数为对应的类的字节码
		try{
		    User user =  BeanUtils.populate(User.class,request);

//		    System.out.println(user);

			//创建好对象，直接查找
			UserServiceImpl userService = new UserServiceImpl();
		    if(userService.isExist(user)){
				request.getRequestDispatcher("/index.jsp").forward(request,response);
			} else{
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			}




		}catch(Exception e){
			e.printStackTrace();
		} 

	 }
	 
}



 



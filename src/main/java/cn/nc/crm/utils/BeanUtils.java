package cn.nc.crm.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class BeanUtils {
  
	
/*	public static <T>   T  populate(Class<T> clazz, HttpServletRequest request) throws Exception{
		Map<String,String[]> parameterMap =request.getParameterMap();
		T t = clazz.newInstance();
		//创建User类的对象
		Set<String> names = parameterMap.keySet();
		//遍历表单中所有的名字
		for(String name:names){
		   //获取表单所对应name的值
		   String[]  nameValues = request.getParameterValues(name);
		   PropertyDescriptor pd =
				   new PropertyDescriptor(name,clazz);
    	   Method method = pd.getWriteMethod();
		   if(nameValues!=null && nameValues.length==1){
	    	  //对象中的相应name设置value值
			   method.invoke(t, nameValues[0]);
	       }else{
	    	    method.invoke(t,new Object[]{nameValues});
	       }
       }
		    return t;
	}*/

	public static <T>   T  populate(Class<T> clazz, HttpServletRequest request) throws Exception{
		T t = clazz.newInstance();

		String name = request.getParameter ("txtName");
		String psw = request.getParameter("txtPwd");

		Method matherName = clazz.getDeclaredMethod("setName", String.class);
		matherName.invoke(t, name);

		Method matherPsw = clazz.getDeclaredMethod("setPassword", String.class);

		matherPsw.invoke(t, psw);


		return t;
	}
}
 
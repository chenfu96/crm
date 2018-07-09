package cn.nc.crm.utils;

import java.lang.reflect.Method;

public class PropertyUtils {
     /**
      * ������Ӧ�ı���(User->user)
      * @param clazz
      * @return
      */
	 public static String getTableName(Class clazz){  
		  String className =clazz.getSimpleName();
		  String tableName =className.substring(0,1).toLowerCase()
				  + className.substring(1);
		  return tableName;
	 }
	 
	 // ���е��ֶ�(id)��������е�������һ��(id)
	 public static void setPropertyValue(Class clazz,Object obj,String columnName,Object columnValue,Class fieldType){
		    //id ->Id;
		  try{
			  String fieldName = columnName.substring(0,1).toUpperCase()
				  + columnName.substring(1);
			   //setId()
			   fieldName = "set"+fieldName;
			   Method method = clazz.getMethod(fieldName,fieldType);
			   method.invoke(obj,columnValue);  
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  
	}
	 
}

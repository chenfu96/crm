package cn.nc.crm.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
   
	
	//Date ->String
	
	public static  String getDate2String(){
		
		 // java.util.Date
	     Date date  = new Date();
	     
	     String dateFormat ="yyyy-MM-dd hh:mm:ss";
	     DateFormat df = new SimpleDateFormat(dateFormat);
	     
	     String strDate = df.format(date);
	     
		 return strDate;
	}
	//String->Date
	public static Date getString2Date(String strDate){
		try{
			String dateFormat ="yyyy-MM-dd hh:mm:ss";
		    DateFormat df = new SimpleDateFormat(dateFormat);
		    Date date = df.parse(strDate);
			return date;
		}catch(Exception e){
			  e.printStackTrace();
			  return null;
		}
	
	}
	
}







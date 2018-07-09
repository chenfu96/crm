package cn.nc.crm.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
      
	  public static String getCurrentDate(){
		  try{
			  DateFormat df  = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			  return df.format(new Date());
		  }catch(Exception e){
			   e.printStackTrace();
			   return null;
		  }
		    
	  }
}

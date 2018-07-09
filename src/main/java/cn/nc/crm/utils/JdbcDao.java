package cn.nc.crm.utils;

import cn.nc.crm.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JdbcDao {
	
	  public static boolean  queryDataByAjax(String data){
		   try{
//			   Class.forName("com.mysql.jdbc.Driver");
//			   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");

			   Connection conn = JdbcUtils.getConnection();
			   String sql ="select *  from t_user where name =?";
			   PreparedStatement pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1,data);
			   ResultSet rs = pstmt.executeQuery();
			   if(rs.next()){
				   return true;
			   }else{
				   return false;
			   }
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		        return false;
	  }
	

}

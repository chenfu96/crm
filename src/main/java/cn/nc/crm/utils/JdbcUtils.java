package cn.nc.crm.utils;

import java.sql.*;

import cn.nc.crm.config.JdbcConfig;

public class JdbcUtils {


	public static Connection getConnection(){
		try{

			Class.forName(JdbcConfig.getIntance().getDRIVERMANAGER());
			return DriverManager.getConnection(JdbcConfig.getIntance().getURL(),
					JdbcConfig.getIntance().getUSERNAME(),JdbcConfig.getIntance().getPASSWORD());
		}catch(Exception e){
			throw  new RuntimeException("创建连接失败");
		}

	}

	public static void close(Connection conn, PreparedStatement pst, ResultSet rs){

		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		if(conn!=null){

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


}

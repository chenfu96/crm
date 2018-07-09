package cn.nc.crm.dao.base.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import cn.nc.crm.base.dao.BaseDao;
import cn.nc.crm.utils.JdbcUtils;
import cn.nc.crm.utils.PropertyUtils;

public class BaseDaoImpl<T> implements BaseDao<T> {
    Class<T> clazz ;
 	public BaseDaoImpl(){
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		//getActualTypeArguments()方法：获取泛型的真实类型,返回值是Type[]
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}
	@Override
	public List<T> queryObjectByConditions( String whereSql, Object... paramsValues) {
		Connection connection =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<T> list = new ArrayList<T>();
		try{
			connection = JdbcUtils.getConnection();
			StringBuffer sql =new StringBuffer("select * from t_"+PropertyUtils.getTableName(clazz)+" where 1=1 " );
			if(whereSql!=null){
				 sql.append(whereSql);
			}	
			pstmt  = connection.prepareStatement(sql.toString());
			if(whereSql!=null ){
				  for(int i=1;i<=paramsValues.length;i++){
					   pstmt.setObject(i,paramsValues[i-1]);
				  }
			}
		    rs = pstmt.executeQuery();
		    ResultSetMetaData metaData = rs.getMetaData();
		    while(rs.next()){ //t_use  (id,name)
		    	 T obj = clazz.newInstance();
		    	 for(int i=1;i<=metaData.getColumnCount();i++){
		    		     String columnName = metaData.getColumnLabel(i);
		    		     Field field = clazz.getDeclaredField(columnName);
		    		     Class<?> fieldType = field.getType();
		    		     Object object = rs.getObject(columnName);
		    		     PropertyUtils.setPropertyValue(clazz, obj, columnName, object, fieldType);
		    	 }
		    	   list.add(obj);
		    }
		      return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			 JdbcUtils.close(connection, pstmt, rs);
		}
		      return null;
	}

	

}

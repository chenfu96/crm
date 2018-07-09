package cn.nc.crm.base.dao;

import java.util.List;

public interface BaseDao<T> {
    
	 public List<T> queryObjectByConditions(String whereSql, Object... paramsValues);
}

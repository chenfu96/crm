package cn.nc.crm.user.service.impl;

import java.util.List;
import cn.nc.crm.bean.User;
import cn.nc.crm.user.dao.UserDao;
import cn.nc.crm.user.dao.impl.UserDaoImpl;
import cn.nc.crm.user.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao =new UserDaoImpl();
	@Override
	public boolean isExist(User user) {
		String whereSql =" and name =? and password= ? ";
		Object[] paramsValues={user.getName(),user.getPassword()};
		List<User> list = userDao.queryObjectByConditions(whereSql, paramsValues);
	    if(list!=null &&list.size()==1){
	    	return true;
	    }else{
	    	return false;
	    }
	}

}

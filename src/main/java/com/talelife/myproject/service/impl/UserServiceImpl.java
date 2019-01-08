package com.talelife.myproject.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talelife.framework.mapper.CrudMapper;
import com.talelife.framework.service.CrudServiceImpl;
import com.talelife.myproject.mapper.UserMapper;
import com.talelife.myproject.model.User;
import com.talelife.myproject.service.UserService;
/**
 * 用户业务实现类
 * date: 2018-09-27 17:46:40
 * 
 * @author Liuweiyao
 * @version 1.0
 */
@Service
public class UserServiceImpl extends CrudServiceImpl<User>  implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public CrudMapper<User> getDao() {
		return this.userMapper;
	}

}
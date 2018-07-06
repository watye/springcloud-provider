package com.talelife.myproject.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.talelife.myproject.model.User;
import com.talelife.myproject.service.UserService;
import com.talelife.myproject.service.UserService.UserQuery;
import com.talelife.util.Page;
import com.talelife.util.Result;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private UserService userService;

	@ApiOperation(value = "获取用户列表")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Result<Page<User>> page() {
		UserQuery query = new UserQuery();
		query.setPageNum(2);
		query.setPageSize(1);
		return Result.success(userService.findPage(query));
	}

	@RequestMapping("/get_user")
	public Result<User> getUser(Long id) {
		return Result.success(userService.findByPK(id));
	}

	@RequestMapping("/add")
	public Result<Object> add() {
		User user = new User();
		user.setAge(11);
		user.setUsername("李1");
		userService.add(user);
		return Result.success();
	}

	@RequestMapping("/delete")
	public Result<Object> delete(long id) {
		userService.delete(id);
		return Result.success();
	}

}

package com.talelife.myproject.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.talelife.framework.entity.Page;
import com.talelife.framework.entity.PageQueryParameter;
import com.talelife.framework.entity.ResponseEntity;
import com.talelife.framework.util.BeanUtils;
import com.talelife.myproject.dto.UserDto;
import com.talelife.myproject.model.User;
import com.talelife.myproject.service.UserService;
import com.talelife.myproject.vo.UserAdd;
import com.talelife.myproject.vo.UserQuery;
import com.talelife.myproject.vo.UserUpdate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户控制器
 * @author lwy
 *
 */
@Api(tags="用户操作接口")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private UserService userService;

	@ApiOperation(value = "分页查询")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<UserDto>> page(@Validated PageQueryParameter<UserQuery> pageQuery) {
		User user = BeanUtils.map(pageQuery.getQuery(), User.class);
		PageInfo<User> page = userService.findListPage(user,pageQuery.getPageNum(), pageQuery.getPageSize());
		List<UserDto> userList = BeanUtils.mapAsList(page.getList(), User.class, UserDto.class);
		return ResponseEntity.ok(new Page<UserDto>(page,userList));
	}

	@ApiOperation(value = "查询单个")
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<UserDto> getUser(@PathVariable @ApiParam(value="用户id") Long id) {
		User user = userService.getById(id);
		return ResponseEntity.ok(BeanUtils.map(user, UserDto.class));
	}

	@ApiOperation(value = "新增")
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public ResponseEntity<Object> add(@Validated UserAdd userAdd) {
		userService.save(BeanUtils.map(userAdd,User.class));
		return ResponseEntity.ok();
	}

	@ApiOperation(value = "修改")
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@PathVariable Long id,UserUpdate userUpdate) {
		userUpdate.setId(id);
		userService.updateById(BeanUtils.map(userUpdate,User.class));
		return ResponseEntity.ok();
	}
	
	@ApiOperation(value = "删除")
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable @ApiParam(value="用户id") Long id) {
		userService.deleteById(id);
		return ResponseEntity.ok();
	}

}

package com.fqw.manager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fqw.manager.vo.User;

@Mapper
public interface UserMapper {

	/*
	 * 查询用户是否存在
	 *
	 * @param username,password
	 * @return user
	 * 
	 * */
	@Select("select username,password,authority from user where username=#{username} and password = #{password}")
	User selectUser(@Param("username") String username,@Param("password") String password);
}

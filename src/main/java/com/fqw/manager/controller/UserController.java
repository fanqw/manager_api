package com.fqw.manager.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fqw.manager.dao.UserMapper;
import com.fqw.manager.vo.Result;
import com.fqw.manager.vo.User;


@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/api/login/account")
	public String login(@RequestBody Map<String, String> params) {
		System.out.println("=======jin");
		Map<String, Object> map = new HashMap<>();
		User user =  userMapper.selectUser(params.get("userName").toString(),params.get("password").toString());
//		System.out.println("user "+user);
		Result result = new Result();
		if(user != null) {
			
			result.setCode(0);
			result.setMsg("登陆成功");
//			result.setData(user);
			result.setCurrentAuthority(user.getAuthority());
			result.setStatus("ok");
			result.setType("account");
			
		}else {
			result.setCode(1);
			result.setMsg("登陆失败");
//			result.setData("{}");
			result.setCurrentAuthority(user.getAuthority());
			result.setStatus("error");
			result.setType("account");
		}
		return result.toJson();
	}

	
	
	@RequestMapping("/test")
	public String test(HttpServletRequest req) {
		System.out.println("req=="+req);
		return "test";
	}

	
}

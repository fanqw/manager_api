package com.fqw.manager.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fqw.manager.dao.ResidentInfoMapper;
import com.fqw.manager.vo.AgeClassify;
import com.fqw.manager.vo.Result;
import util.BaseModel;

@RestController
//@CrossOrigin
public class ResidentController {

	private Logger logger = LoggerFactory.getLogger(ResidentController.class);
	@Autowired
	private ResidentInfoMapper residentInfoMapper;

	public BaseModel<List<AgeClassify>> geta() {
		BaseModel<List<AgeClassify>> res = new BaseModel<>();
		List<AgeClassify> list = null;
		res.setData(list);
		return res;
	}

	@RequestMapping("/api/forms")
	public String login(@RequestBody Map<String, String> params) {
		logger.info("=======jin");
		Result result = new Result();
		String user_id = params.get("user_id").toString();
		int count = residentInfoMapper.selectResidentByUserId(user_id);
		if (count == 0) {
			result.setMessage("error");
		} else {
			result.setMessage("ok");
		}
		return result.toJson();
		// residentInfoMapper.sele
		// Resident resident = new Resident();
		// resident.setUser_id(params.get("user_id").toString());
		// User user =
		// userMapper.selectUser(params.get("userName").toString(),params.get("password").toString());
		// System.out.println("user "+user);
		//
		// if(user != null) {
		// System.out.println("====yes");
		// result.setCode(0);
		// result.setMsg("登陆成功");
		//// result.setData(user);
		// result.setCurrentAuthority(user.getAuthority());
		// result.setStatus("ok");
		// result.setType("account");
		//
		// }else {
		// System.out.println("======no");
		// result.setCode(1);
		// result.setMsg("登陆失败");
		//// result.setData("{}");
		//// result.setCurrentAuthority(user.getAuthority());
		// result.setStatus("error");
		// result.setType("account");
		// }
		// return result.toJson();
	}

}

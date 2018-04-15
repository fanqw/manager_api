package com.fqw.manager.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fqw.manager.dao.ResidentInfoMapper;
import com.fqw.manager.util.FamilySort;
import com.fqw.manager.vo.Resident;
import com.fqw.manager.vo.Test;

@RestController
public class GenerateData {

	@Autowired
	private ResidentInfoMapper residentInfoMapper;
	
	@RequestMapping("/api/addData")
	public String generate() {
		System.out.println("=======>");
		int family_id = 9001;
		for(int i=0;i<2500;i++) {
			if(family_id > 9625) {
				family_id = 9001;
			}
			Resident resident = new Resident();
			Date date = Test.randomDate("1945-01-01","2018-04-01");  
			resident.setBirthday(new java.sql.Date(date.getTime()));
			String birthday = new SimpleDateFormat("yyyyMMdd").format(date);
			resident.setUser_id(Test.autoUserID(birthday));
			Calendar calendar = Calendar.getInstance();
			int index = calendar.get(Calendar.MILLISECOND); 
			resident.setGender(i%2);
			resident.setName(Test.autoName(i));
			resident.setAlive(1);
			if(index>300) {
				family_id++;
			}
			resident.setFamily_id(""+family_id);
			resident.setPhone_number("15036405521");
//	        System.out.println(autoUserID(birthday));  
//	        System.out.println(autoName(1));
			System.out.println("index==="+index);
			residentInfoMapper.insertResident(resident);
		}
		
		return "generate";
	}
	
	@RequestMapping("/api/updateData")
	public String update() {
		for(int i=9001;i<9627;i++) {
			Resident resident = residentInfoMapper.selectResident(i+"");
			if(resident != null) {
				residentInfoMapper.updateRelationship(resident.getUser_id(),FamilySort.户主);
			}
		}
		return "test";
	}

	@RequestMapping("/api/test")
	public String test() {
		return "test";
	}
}

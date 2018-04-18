package com.fqw.manager.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fqw.manager.dao.FamilyInfoMapper;
import com.fqw.manager.dao.ResidentInfoMapper;
import com.fqw.manager.util.FamilySort;
import com.fqw.manager.util.Group;
import com.fqw.manager.vo.Family;
import com.fqw.manager.vo.Resident;
import com.fqw.manager.vo.Test;

@RestController
public class GenerateData {

	@Autowired
	private ResidentInfoMapper residentInfoMapper;
	@Autowired
	private FamilyInfoMapper familyInfoMapper;
	
	@RequestMapping("/api/addData")
	public String generate() {
		System.out.println("=======>");
		int family_id = 9001;
		for(int i=0;i<2617;i++) {
			if(family_id > 9625) {
				family_id = 9001;
			}
			Resident resident = new Resident();
			Date date = Test.randomDate("1925-01-01","2018-04-01");  
			resident.setBirthday(new java.sql.Date(date.getTime()));
			String birthday = new SimpleDateFormat("yyyyMMdd").format(date);
			resident.setUser_id(Test.autoUserID(birthday));
			Calendar calendar = Calendar.getInstance();
			int index = calendar.get(Calendar.MILLISECOND); 
			resident.setGender(i%2);
			resident.setName(Test.autoName(i));
			resident.setAlive(1);
			if(index>500) {
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
		for(int i=9001;i<=9626;i++) {
			Resident resident = residentInfoMapper.selectResident(i+"");
			if(resident != null) {
				residentInfoMapper.updateRelationship(resident.getUser_id(),FamilySort.户主);
			}
		}
		return "test";
	}

	@RequestMapping("/api/saveFamilyInfo")
	public String save() {
		List<Resident> listResident = residentInfoMapper.selectResident1();
		Iterator<Resident> iterator = listResident.iterator();
		while(iterator.hasNext()) {
			Resident resident = iterator.next();
			System.out.println(resident.toString());
			Family  family = new Family();
			family.setUser_id(resident.getUser_id());
			family.setFamily_id(resident.getFamily_id());
			Calendar calendar = Calendar.getInstance();
			int index = calendar.get(Calendar.MILLISECOND); 
			Group group = Group.一组;
			Integer status = 0;
			switch (index%6) {
			case 0:
				group = Group.一组;
				break;
			case 1:
				group = Group.二组;			
				break;
			case 2:
				group = Group.三组;
				break;
			case 3:
				group = Group.四组;
				break;
			case 4:
				group = Group.五组;
				break;
			case 5:
				group = Group.六组;
				break;
			default:
				break;
			}
			switch (index % 4) {
			case 0:
				status = 0;
				break;
			case 1:
				status = 1;			
				break;
			case 2:
				status = 2;
				break;
			case 3:
				status = 3;
				break;
			default:
				break;
			}
			family.setAdress("洛阳市伊川县吕店镇下范村第"+group);
			family.setGroup_type(group);
			family.setIncome_status(status);
			System.out.println(family.toString());
			int a = familyInfoMapper.saveFamilyInfo(family);
			System.out.println(a);
		}
		return "save";
	}
	
	@RequestMapping("/api/test")
	public String test() {
		return "test";
	}
}

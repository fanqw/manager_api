package com.fqw.manager.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fqw.manager.dao.FamilyInfoMapper;
import com.fqw.manager.dao.ResidentInfoMapper;
import com.fqw.manager.util.Group;
import com.fqw.manager.vo.AgeClassify;
import com.fqw.manager.vo.ChartData;
import com.fqw.manager.vo.Family;
import com.fqw.manager.vo.FamilyGroup;
import com.fqw.manager.vo.GenderClassify;
import com.fqw.manager.vo.GroupClassify;
import com.fqw.manager.vo.IncomeClassify;
import com.fqw.manager.vo.Resident;

@RestController
public class ChartDataController {
	
	@Autowired
	private FamilyInfoMapper familyInfoMapper;
	@Autowired
	private ResidentInfoMapper residentInfoMapper;

	@RequestMapping("/api/fake_chart_data")
	public String chartData() {
		//图表一，每户成员总数
		List<FamilyGroup>  list1 = new ArrayList<>();
		List<FamilyGroup>  list2 = new ArrayList<>();
		List<Family> listFamily = familyInfoMapper.selectInfo1();
		Iterator<Family> iteratorFamily = listFamily.iterator();
		while(iteratorFamily.hasNext()) {
			Family family = iteratorFamily.next();
			String family_id  = family.getFamily_id();
			FamilyGroup familyGroup = new FamilyGroup();
			familyGroup.setFamily_id(family_id);
			familyGroup.setGroup(family.getGroup_type());
			familyGroup.setMaster(residentInfoMapper.selectName(family_id).getName());
		    int count = residentInfoMapper.selectCount(family_id);
		    familyGroup.setFamily_count(count);
		    list1.add(familyGroup);
		}
		Collections.sort(list1, new Comparator<FamilyGroup>() {
			@Override
			public int compare(FamilyGroup o1, FamilyGroup o2) {
				int flag = o2.getFamily_count().compareTo(o1.getFamily_count());
				if(flag == 0) {
					return o2.getFamily_id().compareTo(o1.getFamily_id());
				}
					return flag;
			}
			
		});

		int len = list1.size();
		for(int i = 0;i<len;i++) {
			FamilyGroup familyGroup = (FamilyGroup)list1.get(i);
			familyGroup.setIndex(i+1);
			list2.add(familyGroup);
		}
	
		//按年龄分类
		List<AgeClassify> ageClassifies = new ArrayList<>();
		int i = 10;
		String str = "";
		int count=0;
		while(i <= 100) {
			AgeClassify ageClassify = new AgeClassify();
			if(i==10) {
			    str = "0-10岁";
				count = this.selectAgeClassify(i);
				ageClassify.setX(str);
				ageClassify.setY(count);
				ageClassifies.add(ageClassify);
			}else if(i>10 && i<100){
				str = i-9+"-"+i+"岁";
				count = this.selectAgeClassify(i);
				ageClassify.setX(str);
				ageClassify.setY(count);
				ageClassifies.add(ageClassify);
			}else {
				str = ">90岁";
				count = this.selectAgeClassify(90, 200);
				ageClassify.setX(str);
				ageClassify.setY(count);
				ageClassifies.add(ageClassify);
			}
			i=i+10;
		}
		System.out.println(ageClassifies.toString());
		
		//按性别分类
		GenderClassify[] genderClassifies = new GenderClassify[2];
		for(int n =0;n<2;n++) {
			genderClassifies[n] = new GenderClassify(n == 0?"男":"女",residentInfoMapper.selectGenderClassify(n));
		}

		//按收入分类
		IncomeClassify[] incomeClassifies = new IncomeClassify[4];
		for(int m = 0;m<4;m++) {
			String incomeType = "";
			switch (m) {
			case 0:
				incomeType = "普通居民";
				break;
			case 1:
				incomeType = "低保户";
				break;			
			case 2:
				incomeType = "贫困户";	
				break;			
			case 3:
				incomeType = "低保+贫困";		
				break;
			default:
				break;
			}
			incomeClassifies[m]=new IncomeClassify(incomeType, familyInfoMapper.selectIncomeClassifyCount(m));
		}
		
		//按组别分类
		GroupClassify[] groupClassifies = new GroupClassify[6];
		
		for(int n = 0;n<6;n++) {
			Group group = null;
			switch (n) {
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
			groupClassifies[n]=new GroupClassify(group, familyInfoMapper.selectGroupClassifyCount(group));
		}
		
		ChartData chartData = new ChartData();
		chartData.setResidentsData(list2);
		chartData.setAgeClassify(ageClassifies);
		chartData.setGenderClassify(genderClassifies);
		chartData.setResidentCount(residentInfoMapper.selectResidentCount());
		chartData.setIncomeClassify(incomeClassifies);
		chartData.setGroupClassify(groupClassifies);
 		return  chartData.toJson();
	}
	
	//查询年龄分类总数
	public Integer selectAgeClassify(int num) {
		Date currentDate = new Date();
				
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.YEAR, -num+10);
		java.sql.Date date1 = new java.sql.Date(calendar.getTime().getTime());
		
		calendar.setTime(currentDate);
		calendar.add(Calendar.YEAR, -num);
		calendar.add(calendar.DATE, 1);
		java.sql.Date date2 = new java.sql.Date(calendar.getTime().getTime());
		int count = residentInfoMapper.selectAgeClassify(date2, date1);
		System.out.println("date1="+date1+",date2="+date2);
		System.out.println("count"+count);
		return count;
	}
	
	public Integer selectAgeClassify(int num1,int num2) {
		Date currentDate = new Date();
				
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.YEAR, -num1);
		java.sql.Date date1 = new java.sql.Date(calendar.getTime().getTime());
		
		calendar.setTime(currentDate);
		calendar.add(Calendar.YEAR, -num2);
		calendar.add(calendar.DATE, 1);
		java.sql.Date date2 = new java.sql.Date(calendar.getTime().getTime());
		int count = residentInfoMapper.selectAgeClassify(date2, date1);
		System.out.println("date1="+date1+",date2="+date2);
		System.out.println("count"+count);
		return count;
	}
	
	@RequestMapping("/api/test2")
	public String test2() {
		String str = "2010-10-10";
		Resident resident = residentInfoMapper.select1(str);
		System.out.println("res=="+resident);
		return "test";
	}
}

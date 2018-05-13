package com.fqw.manager.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fqw.manager.dao.FamilyInfoMapper;
import com.fqw.manager.dao.ResidentInfoMapper;
import com.fqw.manager.service.TestService;
import com.fqw.manager.util.Group;
import com.fqw.manager.vo.AgeClassify;
import com.fqw.manager.vo.ChartData;
import com.fqw.manager.vo.FamilyGroup;
import com.fqw.manager.vo.GenderClassify;
import com.fqw.manager.vo.GroupClassify;
import com.fqw.manager.vo.IncomeClassify;
import com.fqw.manager.vo.Resident;

@RestController
@RequestMapping("/api/")
//@CrossOrigin
public class ChartDataController {

	@Autowired
	private FamilyInfoMapper familyInfoMapper;
	@Autowired
	private ResidentInfoMapper residentInfoMapper;
    @Autowired
    private TestService testService; // transient
	@RequestMapping("fake_chart_data")
	public String chartData() {
		// 图表一，每户成员总数
		List<FamilyGroup> familyGroups =this.selectFamilyGroup(testService.getFa()) ;  // this.selectFamilyGroup();

		// 按性别分类
		List<GenderClassify> genderClassifies = this.selectGenderClassify();
		// 按年龄分类
		List<AgeClassify> ageClassifies = this.selectAgeClassify();
		// 按收入分类
		List<IncomeClassify> incomeClassifies = this.selectIncomeClassify();
		// 按组别分类
		List<GroupClassify> groupClassifies = this.selectGroupClassify();
		// 查询居民总数
		int residentCount = residentInfoMapper.selectResidentCount();

		ChartData chartData = new ChartData();
		chartData.setResidentsData(familyGroups);
		chartData.setAgeClassify(ageClassifies);
		chartData.setGenderClassify(genderClassifies);
		chartData.setIncomeClassify(incomeClassifies);
		chartData.setGroupClassify(groupClassifies);
		chartData.setResidentCount(residentCount);
		return chartData.toJson();
	}

	// 图表一，每户成员总数
	public List<FamilyGroup> selectFamilyGroup(List list1) {
		List<FamilyGroup> list2 = new ArrayList<>();
		int len = list1.size();
		for (int i = 0; i < len; i++) {
			FamilyGroup familyGroup = (FamilyGroup) list1.get(i);
			familyGroup.setIndex(i + 1);
			list2.add(familyGroup);
		}
		return list2;
	}

	// 按性别分类
	public List<GenderClassify> selectGenderClassify() {
		List<GenderClassify> genderClassifies = new ArrayList<>();
		for (int n = 0; n < 2; n++) {
			genderClassifies.add(new GenderClassify(n == 0 ? "男" : "女", residentInfoMapper.selectGenderClassify(n)));
		}
		return genderClassifies;
	}

	// 按年龄段分类
	public List<AgeClassify> selectAgeClassify() {
		List<AgeClassify> ageClassifies = new ArrayList<>();
		int i = 10;
		String str = "";
		int count = 0;
		while (i <= 100) {
			AgeClassify ageClassify = new AgeClassify();
			if (i == 10) {
				str = "0-10岁";
				count = this.selectAgeClassify(i);
				ageClassify.setX(str);
				ageClassify.setY(count);
				ageClassifies.add(ageClassify);
			} else if (i > 10 && i < 100) {
				str = i - 9 + "-" + i + "岁";
				count = this.selectAgeClassify(i);
				ageClassify.setX(str);
				ageClassify.setY(count);
				ageClassifies.add(ageClassify);
			} else {
				str = ">90岁";
				count = this.selectAgeClassify(90, 200);
				ageClassify.setX(str);
				ageClassify.setY(count);
				ageClassifies.add(ageClassify);
			}
			i = i + 10;
		}
		return ageClassifies;
	}

	// 按收入分类
	public List<IncomeClassify> selectIncomeClassify() {
		List<IncomeClassify> incomeClassifies = new ArrayList<>();
		for (int m = 0; m < 4; m++) {
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
			incomeClassifies.add(new IncomeClassify(incomeType, familyInfoMapper.selectIncomeClassifyCount(m)));
		}
		return incomeClassifies;
	}

	// 按组别分
	public List<GroupClassify> selectGroupClassify() {
		List<GroupClassify> groupClassifies = new ArrayList<>();
		for (int n = 0; n < 6; n++) {
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
			groupClassifies.add(new GroupClassify(group, familyInfoMapper.selectGroupClassifyCount(group)));
		}
		return groupClassifies;
	}

	// 查询年龄分类总数(0-90岁)
	public Integer selectAgeClassify(int num) {
		Date currentDate = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.YEAR, -num + 10);
		java.sql.Date date1 = new java.sql.Date(calendar.getTime().getTime());

		calendar.setTime(currentDate);
		calendar.add(Calendar.YEAR, -num);
		calendar.add(Calendar.DATE, 1);
		java.sql.Date date2 = new java.sql.Date(calendar.getTime().getTime());

		int count = residentInfoMapper.selectAgeClassify(date2, date1);

		// System.out.println("date1=" + date1 + ",date2=" + date2);
		// System.out.println("count" + count);

		return count;
	}

	// 查询年龄分类总数(>90岁)
	public Integer selectAgeClassify(int num1, int num2) {
		Date currentDate = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.YEAR, -num1);
		java.sql.Date date1 = new java.sql.Date(calendar.getTime().getTime());

		calendar.setTime(currentDate);
		calendar.add(Calendar.YEAR, -num2);
		calendar.add(Calendar.DATE, 1);
		java.sql.Date date2 = new java.sql.Date(calendar.getTime().getTime());

		int count = residentInfoMapper.selectAgeClassify(date2, date1);

		// System.out.println("date1=" + date1 + ",date2=" + date2);
		// System.out.println("count" + count);

		return count;
	}

	@RequestMapping("test2")
	public String test2() {
		String str = "2010-10-10";
		Resident resident = residentInfoMapper.select1(str);
		System.out.println("res==" + resident);
		return "test";
	}
}

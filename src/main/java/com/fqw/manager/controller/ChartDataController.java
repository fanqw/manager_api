package com.fqw.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.fqw.manager.util.Group;
import com.fqw.manager.vo.AgeClassify;
import com.fqw.manager.vo.ChartData;
import com.fqw.manager.vo.Family;
import com.fqw.manager.vo.GenderClassify;
import com.fqw.manager.vo.Result;

@RestController
public class ChartDataController {

	@RequestMapping("/api/fake_chart_data")
	public String chartData() {
		//图表一，每户成员总数
		Family[]  familyData = new Family[16];
		familyData[0]= new Family(1,Group.一组,"9007","范文来","8人，5男，3女");
		familyData[1]= new Family(2,Group.二组,"9089","范爱国","8人，4男，4女");
		familyData[2]= new Family(3,Group.一组,"9003","范天赐","8人，5男，3女");
		familyData[3]= new Family(4,Group.五组,"9452","范海军","8人，3男，5女");
		familyData[4]= new Family(5,Group.四组,"9372","范俊伟","8人，3男，5女");
		familyData[5]= new Family(6,Group.三组,"9112","范国辉","8人，5男，3女");
		familyData[6]= new Family(7,Group.二组,"9043","范党徽","7人，4男，3女");
		familyData[7]= new Family(8,Group.一组,"9058","范灿伟","7人，4男，4女");
		familyData[8]= new Family(9,Group.六组,"9257","范军武","7人，3男，4女");
		familyData[9]= new Family(10,Group.四组,"9356","范利民","7人，5男，2女");
		familyData[10]= new Family(11,Group.三组,"9258","范仁和","6人，3男，3女");
		familyData[11]= new Family(12,Group.一组,"9114","范伊川","6人，3男，3女");
		familyData[12]= new Family(13,Group.二组,"9398","范真力","6人，2男，4女");
		familyData[13]= new Family(14,Group.一组,"9472","范喜庆","6人，3男，3女");
		familyData[14]= new Family(15,Group.一组,"9455","范孟子","5人，3男，2女");
		familyData[15]= new Family(16,Group.一组,"9124","范立国","5人，3男，2女");
		
		AgeClassify[] ageClassifies = new AgeClassify[10];
		ageClassifies[0] = new AgeClassify("0-10岁",101);
		ageClassifies[1] = new AgeClassify("11-20岁",403);
		ageClassifies[2] = new AgeClassify("21-30岁",585);
		ageClassifies[3] = new AgeClassify("31-40岁",372);
		ageClassifies[4] = new AgeClassify("41-50岁",255);
		ageClassifies[5] = new AgeClassify("51-60岁",180);
		ageClassifies[6] = new AgeClassify("61-70岁",98);
		ageClassifies[7] = new AgeClassify("71-80岁",35);
		ageClassifies[8] = new AgeClassify("81-90岁",11);
		ageClassifies[9] = new AgeClassify(">90岁",2);
		
		GenderClassify[] genderClassifies = new GenderClassify[2];
		genderClassifies[0] = new GenderClassify("男",1054);
		genderClassifies[1] = new GenderClassify("女",988);
		
		ChartData chartData = new ChartData();
		chartData.setSearchData(familyData);
		chartData.setAgeClassify(ageClassifies);
		chartData.setGenderClassify(genderClassifies);
		chartData.setResidentCount(2042);
 		return  chartData.toJson();
	}
}

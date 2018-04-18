package com.fqw.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fqw.manager.util.Group;
import com.fqw.manager.vo.Family;

@Mapper
public interface FamilyInfoMapper {

	/**
	 * 保存家庭信息
	 * @param Family
	 * 
	 * */
	@Insert("Insert into family_info (family_id,user_id,group_type,adress,income_status) values (#{family_id},#{user_id},#{group_type},#{adress},#{income_status})")
	int saveFamilyInfo(Family family);
	
	/**
	 * 查询每户人家的户号，和户主身份证号
	 * @return Integer
	 * 
	 * */
	@Select("select family_id,user_id,group_type from family_info")
	List<Family> selectInfo1();
	
	/**
	 * 
	 * 根据收入状态，查询各类家庭总数
	 * @param Integer
	 * @return Integer
	 * 
	 * */
	@Select("select count(family_id) from family_info where income_status = #{income_status}")
	Integer selectIncomeClassifyCount(@Param("income_status")Integer income_status);
	
	/**
	 * 
	 * 根据分组，查询各类家庭总数
	 * @param Group
	 * @return Integer
	 * 
	 * */
	@Select("select count(family_id) from family_info where group_type = #{group_type}")
	Integer selectGroupClassifyCount(@Param("group_type")Group group_type);
}

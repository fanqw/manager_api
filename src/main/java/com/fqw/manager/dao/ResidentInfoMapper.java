package com.fqw.manager.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.fqw.manager.util.FamilySort;
import com.fqw.manager.vo.Resident;

@Mapper
public interface ResidentInfoMapper {

	/*
	 * 添加测试数据
	 *
	 * @param Resident
	 * 
	 * 
	 * */
	
	@Insert("Insert into resident_info (user_id,name,gender,birthday,family_id,phone_number,alive) values (#{user_id},#{name},#{gender},#{birthday},#{family_id},#{phone_number},#{alive})")
	int insertResident(Resident resident);

	@Select("Select * from resident_info where family_id = #{family_id} order by birthday limit 1")
	Resident selectResident(@Param("family_id")String family_id);
	
	@Update("Update resident_info set relationship = #{relationship} where user_id = #{user_id}")
	int updateRelationship(@Param("user_id") String user_id,@Param("relationship") FamilySort relationship);
}

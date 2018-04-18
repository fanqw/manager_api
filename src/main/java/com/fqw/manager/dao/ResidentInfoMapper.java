package com.fqw.manager.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.fqw.manager.util.FamilySort;
import com.fqw.manager.vo.Resident;

@Mapper
public interface ResidentInfoMapper {

	/**
	 * 添加测试数据
	 * @param Resident
	 * */
	
	@Insert("Insert into resident_info (user_id,name,gender,birthday,family_id,phone_number,alive) values (#{user_id},#{name},#{gender},#{birthday},#{family_id},#{phone_number},#{alive})")
	int insertResident(Resident resident);

	@Select("Select * from resident_info where family_id = #{family_id} order by birthday limit 1")
	Resident selectResident(@Param("family_id")String family_id);
	
	/**
	 * 为每户添加户主
	 * @param String,FamilySort
	 * @return Integer
	 * */
	@Update("Update resident_info set relationship = #{relationship} where user_id = #{user_id}")
	int updateRelationship(@Param("user_id") String user_id,@Param("relationship") FamilySort relationship);

	/**
	 * 查询所有户主的信息
	 * */
    @Select("Select user_id,family_id from resident_info where relationship = '户主'")
    List<Resident> selectResident1();
    
//    /**
//     * 查询每户人家，男女各有多少人
//     * 
//     * @param String,Integer
//     * @return Integer
//     * 
//     * */
//    @Select("Select count(user_id) from resident_info where family_id = #{family_id} and gender = #{gender}")
//    int selectCount(@Param("family_id")String family_id,@Param("gender")Integer gender);
    
    /**
     * 根据户号查询每户人家共多少人
     * 
     * @param String
     * @return Integer
     * 
     * */
    @Select("Select count(user_id) from resident_info where family_id = #{family_id}")
    int selectCount(@Param("family_id")String family_id);
    
    /**
     * 根据户号查询户主名字
     * @param String
     * @return Resident
     * */
    @Select("select name from resident_info where family_id = #{family_id} and relationship = '户主'")
    Resident selectName(@Param("family_id")String family_id);

    /**
     * 根据性别查询人口总数
     * @param Integer
     * @return Integer
     * */
    @Select("select count(user_id) from resident_info where gender=#{gender}")
    Integer selectGenderClassify(@Param("gender")Integer gender);
    
    /**
     * 根据年龄段查询人口总数
     * @param Date 
     * @return Integer
     * */
    @Select ("select count(user_id) from resident_info where birthday Between #{date1} and #{date2}")
    int selectAgeClassify(@Param("date1")Date date1,@Param("date2")Date date2);

   /**
    * 查询所有人数
    * @return Integer
    * */
    @Select("select count(user_id) from resident_info where alive = 1")
    Integer selectResidentCount();
    
    /**
     * 测试根据生日查询信息
     * 
     * */
    @Select("select * from resident_info where birthday = #{date}")
    Resident select1(@Param("date")String date );
}

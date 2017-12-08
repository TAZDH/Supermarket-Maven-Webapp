package com.hs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hs.entity.SmbmsUser;

public interface SmbmsUserDao {
	/**
	 * 添加用户
	 * 
	 * @param smbmsUser
	 * @return
	 */
	Integer addSmbmsUser(SmbmsUser smbmsUser);

	/**
	 * 更新用户
	 * 
	 * @param smbmsUser
	 * @return
	 */
	Integer updateSmbmsUser(SmbmsUser smbmsUser);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteSmbmsUser(Integer id);
	
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	SmbmsUser getSmbmsUserById(Integer id);

	/**
	 * 登陆
	 * 
	 * @param smbmsUser
	 * @return
	 */
	SmbmsUser login(SmbmsUser smbmsUser);

	/**
	 * 按条件查询并分页
	 * 
	 * @param userName
	 * @param userRole
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<SmbmsUser> getSmbmsUserByPage(@Param("userName") String userName,
			@Param("userRole") Integer userRole, @Param("page") Integer page,
			@Param("pageSize") Integer pageSize);
	
	/**
	 * 查询用户总数
	 * @return
	 */
	Integer getAllSmbmsUser(@Param("userName") String userName,
			@Param("userRole") Integer userRole);
	
	/**
	 * 比较用户
	 * @param userCode
	 * @return
	 */
	Integer userCompare(String userCode);
}

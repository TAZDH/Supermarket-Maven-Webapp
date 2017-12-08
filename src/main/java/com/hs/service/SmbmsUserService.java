package com.hs.service;

import java.util.List;


import com.hs.entity.SmbmsUser;

public interface SmbmsUserService {
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
	 * 
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
	List<SmbmsUser> getSmbmsUserByPage(String userName, Integer userRole,
			Integer page, Integer pageSize);

	/**
	 * 查询用户总数
	 * 
	 * @return
	 */
	Integer getAllSmbmsUser(String userName, Integer userRole);
	
	/**
	 * 比较用户
	 * @param userCode
	 * @return
	 */
	SmbmsUser userCompare(String userCode);
}

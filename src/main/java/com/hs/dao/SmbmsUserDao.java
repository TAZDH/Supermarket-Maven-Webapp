package com.hs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hs.entity.SmbmsUser;

public interface SmbmsUserDao {
	/**
	 * ����û�
	 * 
	 * @param smbmsUser
	 * @return
	 */
	Integer addSmbmsUser(SmbmsUser smbmsUser);

	/**
	 * �����û�
	 * 
	 * @param smbmsUser
	 * @return
	 */
	Integer updateSmbmsUser(SmbmsUser smbmsUser);

	/**
	 * ɾ��
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteSmbmsUser(Integer id);
	
	
	/**
	 * ����id��ѯ�û�
	 * @param id
	 * @return
	 */
	SmbmsUser getSmbmsUserById(Integer id);

	/**
	 * ��½
	 * 
	 * @param smbmsUser
	 * @return
	 */
	SmbmsUser login(SmbmsUser smbmsUser);

	/**
	 * ��������ѯ����ҳ
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
	 * ��ѯ�û�����
	 * @return
	 */
	Integer getAllSmbmsUser(@Param("userName") String userName,
			@Param("userRole") Integer userRole);
	
	/**
	 * �Ƚ��û�
	 * @param userCode
	 * @return
	 */
	Integer userCompare(String userCode);
}

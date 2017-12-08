package com.hs.service;

import java.util.List;


import com.hs.entity.SmbmsUser;

public interface SmbmsUserService {
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
	 * 
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
	List<SmbmsUser> getSmbmsUserByPage(String userName, Integer userRole,
			Integer page, Integer pageSize);

	/**
	 * ��ѯ�û�����
	 * 
	 * @return
	 */
	Integer getAllSmbmsUser(String userName, Integer userRole);
	
	/**
	 * �Ƚ��û�
	 * @param userCode
	 * @return
	 */
	SmbmsUser userCompare(String userCode);
}

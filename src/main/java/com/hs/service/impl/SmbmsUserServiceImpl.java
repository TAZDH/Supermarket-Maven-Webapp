package com.hs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.dao.SmbmsUserDao;
import com.hs.entity.SmbmsUser;
import com.hs.service.SmbmsUserService;

@Service
public class SmbmsUserServiceImpl implements SmbmsUserService {

	@Autowired
	private SmbmsUserDao dao;
	
	public Integer addSmbmsUser(SmbmsUser smbmsUser) {
		// TODO Auto-generated method stub
		return dao.addSmbmsUser(smbmsUser);
	}

	public Integer updateSmbmsUser(SmbmsUser smbmsUser) {
		// TODO Auto-generated method stub
		return dao.updateSmbmsUser(smbmsUser);
	}

	public Integer deleteSmbmsUser(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteSmbmsUser(id);
	}

	public SmbmsUser getSmbmsUserById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getSmbmsUserById(id);
	}

	public SmbmsUser login(SmbmsUser smbmsUser) {
		// TODO Auto-generated method stub
		return dao.login(smbmsUser);
	}

	public List<SmbmsUser> getSmbmsUserByPage(String userName, Integer userRole,
			Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return dao.getSmbmsUserByPage(userName, userRole,(page-1)*pageSize, pageSize);
	}

	public Integer getAllSmbmsUser(String userName, Integer userRole) {
		// TODO Auto-generated method stub
		return dao.getAllSmbmsUser(userName,userRole);
	}

	public SmbmsUser userCompare(String userCode) {
		// TODO Auto-generated method stub
		int rows = dao.userCompare(userCode);
		return rows>0?new SmbmsUser("exist"):new SmbmsUser("");

	}

}

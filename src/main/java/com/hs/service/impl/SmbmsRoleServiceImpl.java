package com.hs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.dao.SmbmsRoleDao;
import com.hs.entity.SmbmsRole;
import com.hs.service.SmbmsRoleService;
@Service
public class SmbmsRoleServiceImpl implements SmbmsRoleService {
	@Autowired
	private SmbmsRoleDao dao;
	
	public List<SmbmsRole> getAllSmbmsRole() {
		// TODO Auto-generated method stub
		return dao.getAllSmbmsRole();
	}

}

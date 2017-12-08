package com.hs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.dao.SmbmsProviderDao;
import com.hs.entity.SmbmsProvider;
import com.hs.service.SmbmsProviderService;
@Service
public class SmbmsProviderServiceImpl implements SmbmsProviderService {
	@Autowired
	private SmbmsProviderDao dao;
	
	public Integer addSmbmsProvider(SmbmsProvider smbmsProvider) {
		// TODO Auto-generated method stub
		return dao.addSmbmsProvider(smbmsProvider);
	}

	public Integer updateSmbmsProvider(SmbmsProvider smbmsProvider) {
		// TODO Auto-generated method stub
		return dao.updateSmbmsProvider(smbmsProvider);
	}

	public Integer deleteSmbmsProvider(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteSmbmsProvider(id);
	}

	public SmbmsProvider getSmbmsProviderById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getSmbmsProviderById(id);
	}

	public List<SmbmsProvider> getAllSmbmsProviders(String proCode,
			String proName, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return dao.getAllSmbmsProviders(proCode, proName, (page-1)*pageSize, pageSize);
	}

	public Integer getSmbmsProviders(String proCode, String proName) {
		// TODO Auto-generated method stub
		return dao.getSmbmsProviders(proCode, proName);
	}

}

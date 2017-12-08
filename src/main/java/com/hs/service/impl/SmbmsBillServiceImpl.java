package com.hs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.dao.SmbmsBillDao;
import com.hs.entity.SmbmsBill;
import com.hs.service.SmbmsBillService;
@Service
public class SmbmsBillServiceImpl implements SmbmsBillService {
	@Autowired
	private SmbmsBillDao dao;
	
	public List<SmbmsBill> getAllSmbmsBill(String productName,
			Integer providerId, Integer queryIsPayment) {
		// TODO Auto-generated method stub
		return dao.getAllSmbmsBill(productName, providerId, queryIsPayment);
	}

}

package com.hs.service;

import java.util.List;


import com.hs.entity.SmbmsBill;

public interface SmbmsBillService {
	/**
	 * ��ѯ
	 * 
	 * @param productName
	 * @param providerId
	 * @param queryIsPayment
	 * @return
	 */
	List<SmbmsBill> getAllSmbmsBill(String productName, Integer providerId,
			Integer queryIsPayment);

}

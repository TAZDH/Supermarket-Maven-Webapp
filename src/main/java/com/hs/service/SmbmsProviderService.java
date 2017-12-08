package com.hs.service;

import java.util.List;



import com.hs.entity.SmbmsProvider;

public interface SmbmsProviderService {
	/**
	 * ���
	 * 
	 * @param smbmsProvider
	 * @return
	 */
	Integer addSmbmsProvider(SmbmsProvider smbmsProvider);

	/**
	 * ����
	 * 
	 * @param smbmsProvider
	 * @return
	 */
	Integer updateSmbmsProvider(SmbmsProvider smbmsProvider);

	/**
	 * ɾ��
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteSmbmsProvider(Integer id);

	/**
	 * �鿴
	 * 
	 * @param id
	 * @return
	 */
	SmbmsProvider getSmbmsProviderById(Integer id);

	/**
	 * ȫ����Ӧ��
	 * 
	 * @param proCode
	 * @param proName
	 * @return
	 */
	List<SmbmsProvider> getAllSmbmsProviders(String proCode, String proName,
			Integer page, Integer pageSize);
	
	Integer getSmbmsProviders(String proCode, String proName);
}

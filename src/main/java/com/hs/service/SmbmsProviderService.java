package com.hs.service;

import java.util.List;



import com.hs.entity.SmbmsProvider;

public interface SmbmsProviderService {
	/**
	 * 添加
	 * 
	 * @param smbmsProvider
	 * @return
	 */
	Integer addSmbmsProvider(SmbmsProvider smbmsProvider);

	/**
	 * 更新
	 * 
	 * @param smbmsProvider
	 * @return
	 */
	Integer updateSmbmsProvider(SmbmsProvider smbmsProvider);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteSmbmsProvider(Integer id);

	/**
	 * 查看
	 * 
	 * @param id
	 * @return
	 */
	SmbmsProvider getSmbmsProviderById(Integer id);

	/**
	 * 全部供应商
	 * 
	 * @param proCode
	 * @param proName
	 * @return
	 */
	List<SmbmsProvider> getAllSmbmsProviders(String proCode, String proName,
			Integer page, Integer pageSize);
	
	Integer getSmbmsProviders(String proCode, String proName);
}

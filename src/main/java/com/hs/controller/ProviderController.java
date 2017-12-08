package com.hs.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.hs.entity.SmbmsProvider;
import com.hs.service.SmbmsProviderService;

@Controller
@RequestMapping("jsp")
public class ProviderController {
	@Autowired
	private SmbmsProviderService providerService;
	private int pageSize = 5;

	/**
	 * 
	 * ��ѯȫ��
	 * 
	 * @param queryProCode
	 * @param queryProName
	 * @param model
	 * @return
	 */
	@RequestMapping("provider.do")
	public String getProviderList(String queryProCode, String queryProName,
			@RequestParam(defaultValue = "1") Integer pageIndex,
			Map<String, Object> model) {
		List<SmbmsProvider> providers = providerService.getAllSmbmsProviders(
				queryProCode, queryProName, pageIndex, pageSize);
		// ��ѯ�ܼ�¼
		int totalCount = providerService.getSmbmsProviders(queryProCode, queryProName);
		// ��ҳ��
		int totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		model.put("providerList", providers);
		model.put("queryProCode", queryProCode);
		model.put("queryProName", queryProName);
		// �ܼ�¼��
		model.put("totalCount", totalCount);
		// ��ǰҳ
		model.put("currentPageNo", pageIndex);
		// ��ҳ��
		model.put("totalPageCount", totalPageCount);
		return "jsp/providerlist";
	}

	/**
	 * ��ѯ����
	 * 
	 * @param proid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "proById/{proid}", method = RequestMethod.GET)
	public String getProviderById(@PathVariable Integer proid,
			Map<String, Object> model) {
		SmbmsProvider provider = providerService.getSmbmsProviderById(proid);
		model.put("provider", provider);

		String str = provider.getPhoto();
		String[] strs = str.split(",");
		List<String> photos = new ArrayList<String>();
		for (int i = 0, len = strs.length; i < len; i++) {
			photos.add(strs[i].toString());
		}
		model.put("photos", photos);

		return "jsp/providerview";

	}

	/**
	 * ǰ������
	 * 
	 * @param proid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "gotoUpdateProvider/{proid}", method = RequestMethod.GET)
	public String gotoUpdateProvider(@PathVariable Integer proid,
			Map<String, Object> model) {
		model.put("provider", providerService.getSmbmsProviderById(proid));
		return "jsp/providermodify";
	}

	/**
	 * ����
	 * 
	 * @param provider
	 * @param model
	 * @return
	 */
	@RequestMapping("updateProvider.do")
	public String updateProvider(SmbmsProvider provider,
			Map<String, Object> model) {
		if (providerService.updateSmbmsProvider(provider) > 0) {
			return "redirect:provider.do";
		}
		model.put("provider", provider);
		return "jsp/providermodify";
	}

	/**
	 * ǰ�����
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("gotoAddProvider.do")
	public String gotoAddProvider(Map<String, Object> model) {
		model.put("provider", new SmbmsProvider());
		return "jsp/provideradd";
	}

	/**
	 * ���
	 * 
	 * @param provider
	 * @param result
	 * @param photos
	 * @param req
	 * @return
	 */
	@RequestMapping("addAndUploadProvider.do")
	public String addAndUploadProvider(
			@ModelAttribute("provider") @Valid SmbmsProvider provider,
			BindingResult result,
			@RequestParam("photos") MultipartFile[] photos,
			HttpServletRequest req) {
		// �ļ��Ƿ�Ϊ��
		if (!result.hasErrors()) {
			// �����ļ���
			String path = req.getSession().getServletContext()
					.getRealPath("photos");
			// ������Ϣ����
			List<String> errors = new ArrayList<String>();
			// ͼƬ������
			List<String> fileNames = new ArrayList<String>();
			// ѭ�����
			for (MultipartFile string : photos) {
				String err = getErrInfo(string);
				// ͨ��
				if (err == null) {
					// �ϴ�
					String fileName = upload(string, path);
					// ��ӵ�����
					fileNames.add(fileName);
				} else {
					// ���������Ϣ���
					errors.add(err);
				}
			}
			// ������һ��ͨ��
			if (fileNames.size() > 0) {
				StringBuilder sb = new StringBuilder();
				sb.append("photos" + "/" + fileNames.get(0));
				sb.append(",photos" + "/" + fileNames.get(1));
				provider.setPhoto(sb.toString());
				// ��ӳɹ�
				if (providerService.addSmbmsProvider(provider) > 0) {
					return "redirect:provider.do";
				}
			}

			req.setAttribute("errors", errors);
			req.setAttribute("filenames", fileNames);
		}

		return "jsp/provideradd";

	}

	/**
	 * �ж��ϴ��ļ�
	 * 
	 * @param photo
	 * @return
	 */
	public String getErrInfo(MultipartFile photo) {
		// ��ȡͼƬ����
		String fileName = photo.getOriginalFilename();
		// ͼƬ��ʽ
		String suf = FilenameUtils.getExtension(fileName);
		// ������Ϣ
		String err = null;
		// �ж�
		if (photo.isEmpty()) {
			err = String.format("%s���ϴ��ļ�����Ϊ��", fileName);
		} else if (photo.getSize() > 50000000000L) {
			err = String.format("%s���ϴ��ļ���С���ܳ���500KB", fileName);
		} else if (!formats.contains(suf.toLowerCase())) {
			err = String.format("%s���ϴ��ļ���ʽ����ȷ��֧�ֵĸ�ʽ��%s", fileName, formats);
		}
		return err;
	}

	// ��ʽ����
	static List<String> formats = new ArrayList<String>();
	static {
		formats.add("png");
		formats.add("jpg");
		formats.add("jpeg");
		formats.add("pneg");
	}

	/**
	 * �ϴ�
	 * 
	 * @return
	 */
	public String upload(MultipartFile photo, String path) {
		// ��ȡ����
		String fileName = photo.getOriginalFilename();
		// ��ȡ��ǰʱ��
		long time = System.currentTimeMillis();
		String photoname = "_" + time + "_" + fileName;
		File dest = new File(path, photoname);
		try {
			photo.transferTo(dest);
			return photoname;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@ResponseBody
	@RequestMapping("deleteProvider.do")
	public String deleteProvider(Integer proid) {
		if (providerService.deleteSmbmsProvider(proid) > 0) {
			return JSONObject.toJSONString("true");
		}
		return JSONObject.toJSONString("false");
	}
}

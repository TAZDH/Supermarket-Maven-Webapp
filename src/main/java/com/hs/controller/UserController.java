package com.hs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hs.entity.SmbmsRole;
import com.hs.entity.SmbmsUser;
import com.hs.service.SmbmsRoleService;
import com.hs.service.SmbmsUserService;

@Controller
@RequestMapping("jsp")
public class UserController {

	@Autowired
	private SmbmsUserService userService;
	@Autowired
	private SmbmsRoleService roleService;

	private int pageSize = 5;

	/**
	 * ��½
	 * 
	 * @param userCode
	 * @param userPassword
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("login.do")
	public String login(String userCode, String userPassword,
			HttpSession session, Map<String, Object> model) {
		SmbmsUser smbmsUser = new SmbmsUser();
		smbmsUser.setUserCode(userCode);
		smbmsUser.setUserPassword(userPassword);
		SmbmsUser us = userService.login(smbmsUser);
		if (us != null) {
			session.setAttribute("userSession", us);
			return "jsp/frame";
		}
		model.put("error", "�û������������!!!");
		return "login";
	}

	/**
	 * �˳�
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("userSession");
		return "login";
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param queryname
	 * @param queryUserRole
	 * @param pageIndex
	 * @param model
	 * @return
	 */
	@RequestMapping("user.do")
	public String getUserList(String queryname, Integer queryUserRole,
			@RequestParam(defaultValue = "1") Integer pageIndex,
			Map<String, Object> model) {
		// ������
		List<SmbmsUser> user = userService.getSmbmsUserByPage(queryname,
				queryUserRole, pageIndex, pageSize);
		// ��ѯ�ܼ�¼
		int totalCount = userService.getAllSmbmsUser(queryname, queryUserRole);
		// ��ҳ��
		int totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		// ���ȫ��
		List<SmbmsRole> role = roleService.getAllSmbmsRole();

		model.put("userList", user);
		model.put("roleList", role);
		model.put("queryUserName", queryname);
		model.put("queryUserRole", queryUserRole);
		// �ܼ�¼��
		model.put("totalCount", totalCount);
		// ��ǰҳ
		model.put("currentPageNo", pageIndex);
		// ��ҳ��
		model.put("totalPageCount", totalPageCount);

		return "jsp/userlist";
	}
	/**
	 * ǰ������
	 * @return
	 */
	@RequestMapping("gotoUpdateUser.do")
	public String gotoUpdateUser() {
		return null;
	}
	/**
	 * ����Ƿ���ͬ
	 * @param userCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping("userCompare.do")
	public String userCompare(String userCode) {
		return JSONObject.toJSONString(userService.userCompare(userCode));
	}
	/**
	 * ǰ�����
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping("addUser.do")
	public String addUser(@ModelAttribute("user") @Valid SmbmsUser user,
			BindingResult result) {
		if (userService.addSmbmsUser(user) > 0) {
			return "redirect:user.do";
		}
		return "jsp/useradd";
	}
	/**
	 * ���
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("gotoAddUser.do")
	public String gotoAddUser(Map<String, Object> model, HttpSession session) {
		Map<Integer, String> genders = new HashMap<Integer, String>();
		genders.put(1, "��");
		genders.put(2, "Ů");
		model.put("user", new SmbmsUser());
		session.setAttribute("genders", genders);
		return "jsp/useradd";
	}
	
	/**
	 * �鿴
	 * @param userid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "getUserById/{userid}", method = RequestMethod.GET)
	public String getUserById(@PathVariable Integer userid,
			Map<String, Object> model){
		model.put("user", userService.getSmbmsUserById(userid));
		return "jsp/userview";
	}
	/**
	 * ǰ������
	 * @param userid
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "gotoUpdateUser/{userid}", method = RequestMethod.GET)
	public String gotoUpdateUser(@PathVariable Integer userid,Map<String, Object> model, HttpSession session){
		model.put("user", userService.getSmbmsUserById(userid));
		Map<Integer, String> genders = new HashMap<Integer, String>();
		genders.put(1, "��");
		genders.put(2, "Ů");
		session.setAttribute("genders", genders);
		return "jsp/usermodify";
	}
	
	/**
	 * ����
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping("updateUser.do")
	public String updateUser(@ModelAttribute("user") @Valid SmbmsUser user,
			BindingResult result) {
		if (userService.updateSmbmsUser(user) > 0) {
			return "redirect:user.do";
		}
		return "jsp/usermodify";
	}
	/**
	 * ɾ��
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteUser.do", method = RequestMethod.GET)
	public String deleteUser(Integer uid){
		if (userService.deleteSmbmsUser(uid) > 0) {
			return JSONObject.toJSONString("true");
		}
		return JSONObject.toJSONString("false");
	}
}

package com.hs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.hs.service.SmbmsRoleService;

@Controller
@RequestMapping("jsp")
public class RoleController {
	@Autowired
	private SmbmsRoleService roleService;
	
	/*@RequestMapping("roleList")
	public String getAllRole(Map<String,Object> model){
		model.put("roles", roleService.getAllSmbmsRole());
		return "jsp/roleList";
	}*/
	
	@ResponseBody
	@RequestMapping("roleList.do")
	public String getRoleList(){
		return JSONArray.toJSONString(roleService.getAllSmbmsRole());
	}
}

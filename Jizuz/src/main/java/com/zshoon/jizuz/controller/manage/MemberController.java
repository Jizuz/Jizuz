/*
 * Copyright (C), 2002-2018, 苏宁易购电子商务有限公司
 * FileName: MemberController.java
 * Author:   17081480
 * Date:     2018年1月2日 下午5:06:29
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.zshoon.jizuz.controller.manage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zshoon.jizuz.common.utils.CommonUtil;
import com.zshoon.jizuz.common.utils.DateUtil;
import com.zshoon.jizuz.entity.dto.RoleDto;
import com.zshoon.jizuz.entity.dto.UserDto;
import com.zshoon.jizuz.entity.po.RolePo;
import com.zshoon.jizuz.entity.po.UserPo;
import com.zshoon.jizuz.service.IUserService;

/**
 * 〈用户会员控制器〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
@Controller
public class MemberController {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	/**
	 * userService
	 */
	@Autowired
	private IUserService userService;

	/**
	 * 〈进入会员管理页面〉
	 *
	 * @param model Model
	 * @return String
	 * @author Jizuz
	 * @since v1.0.0
	 */
	@RequestMapping("/memberMgt")
	public String toMemberMgt(Model model) {
		List<UserDto> userList = userService.findUsers();
		if (CommonUtil.isEmpty(userList)) {
			model.addAttribute("users", new ArrayList<UserDto>());
		} else {
			model.addAttribute("users", userList);
		}
		model.addAttribute("page", "memberMgt");
		return "common";
	}

	/**
	 * 〈根据uid查询用户信息〉
	 *
	 * @param uid String
	 * @return String
	 * @author Jizuz
	 * @since v1.0.0
	 */
	@ResponseBody
	@RequestMapping(value = "getUserById", method = RequestMethod.POST)
	public String getMemberById(@RequestParam String uid) {
		UserDto user = userService.findUserBuUid(Integer.parseInt(uid));
		String date = DateUtil.stringDate2String(user.getBirthday(), DateUtil.DATE_FORMAT_1);
		user.setBirthday(date);
		logger.debug("user = {}", JSON.toJSONString(user));

		String ret = JSON.toJSONString(user);
		return ret;
	}

	/**
	 * 〈根据uid更新用户信息〉
	 *
	 * @param request HttpServletRequest
	 * @return String
	 * @author Jizuz
	 * @since v1.0.0
	 */
	@ResponseBody
	@RequestMapping(value = "updateUserById", method = RequestMethod.POST)
	public String updateUserById(HttpServletRequest request) {
		String rid = request.getParameter("rid");

		UserDto userDto = new UserDto();
		userDto.setUid(Long.valueOf(request.getParameter("uid")));
		userDto.setUserName(request.getParameter("userName"));
		userDto.setTel(request.getParameter("tel"));
		userDto.setEmail(request.getParameter("email"));
		userDto.setCompany(request.getParameter("company"));

		RoleDto roleDto = new RoleDto();
		roleDto.setRid(Long.valueOf(rid));

		UserPo userPo = new UserPo();
		BeanUtils.copyProperties(userDto, userPo);
		RolePo rolePo = new RolePo();
		BeanUtils.copyProperties(roleDto, rolePo);
		userPo.setRole(rolePo);

		userService.updateUserAndRole(userPo, rolePo);
		return JSON.toJSONString("success");
	}

}

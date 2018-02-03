package com.zshoon.jizuz.controller.life;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zshoon.jizuz.common.utils.CommonUtil;
import com.zshoon.jizuz.entity.dto.TimeAxisDto;
import com.zshoon.jizuz.service.ITimeAxisService;

/**
 * 〈时间控制器〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
@Controller
public class TimesController {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(TimesController.class);

	/**
	 * timeAxisService
	 */
	@Autowired
	private ITimeAxisService timeAxisService;

	/**
	 * <Description> 查询时间轴
	 * 
	 * @author Jizuz
	 * @param model
	 * @return String
	 */
	@RequestMapping("times")
	public String getTimeAxis(Model model) {
		logger.debug("getTimeAxis begin ...");
		List<TimeAxisDto> taDtoList = timeAxisService.findTimeAxis();
		if (CommonUtil.isEmpty(taDtoList)) {
			model.addAttribute("timeAxisList", new ArrayList<TimeAxisDto>());
		} else {
			model.addAttribute("timeAxisList", taDtoList);
		}
		model.addAttribute("page", "times");
		logger.debug("getTimeAxis end ...");
		return "common";
	}
}

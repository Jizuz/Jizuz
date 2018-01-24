package com.zshoon.jizuz.controller.photograph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈图片页面控制器〉
 *
 * @author Jizuz
 * @since v1.0.0
 */
@Controller
public class PhotoController {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(PhotoController.class);
	
	/**
	 * 〈进入图片展示页面〉
	 *
	 * @param model
	 * @return
	 * @author Jizuz
	 * @since v1.0.0
	 */
	@RequestMapping("/photo")
	public String toPhoto(Model model) {
		logger.debug("toPhoto begin ...");
		model.addAttribute("page", "photo");
		model.addAttribute("photoPath", "img/thumbnails/picjumbo.com_IMG_4566.jpg");
		
		logger.debug("toPhoto end ...");
		return "common";
	}
	
}

package com.zshoon.jizuz.controller.photograph;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zshoon.jizuz.common.utils.CommonUtil;
import com.zshoon.jizuz.entity.dto.PThemeDto;
import com.zshoon.jizuz.entity.dto.PhotoDto;
import com.zshoon.jizuz.entity.dto.PhotoThemeDto;
import com.zshoon.jizuz.service.IPhotoService;

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
	 * photoService
	 */
	@Autowired
	private IPhotoService photoService;
	
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
		List<PhotoThemeDto> ptDtoList = new ArrayList<>();
		List<PThemeDto> themeList = photoService.getPhotoThemes();
		if (CommonUtil.isNotEmpty(themeList)) {
			for (PThemeDto themeDto : themeList) {
				PhotoThemeDto ptDto = new PhotoThemeDto();
				List<PhotoDto> photoList = photoService.getPhotosByTid(themeDto.getTid());
				if (CommonUtil.isNotEmpty(photoList)) {
					ptDto.setTid(themeDto.getTid());
					ptDto.setTheme(themeDto.getTheme());
					ptDto.setPhotoList(photoList);
					ptDtoList.add(ptDto);
				}
			}
		}
		
		model.addAttribute("photoThemes", ptDtoList);
		
		logger.debug("toPhoto end ...");
		return "common";
	}
	
}

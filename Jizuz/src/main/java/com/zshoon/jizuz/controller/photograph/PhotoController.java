package com.zshoon.jizuz.controller.photograph;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zshoon.jizuz.common.constants.SymbolConstant;
import com.zshoon.jizuz.common.utils.CommonUtil;
import com.zshoon.jizuz.common.utils.DateUtil;
import com.zshoon.jizuz.common.utils.RandomUtil;
import com.zshoon.jizuz.common.utils.StringUtil;
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

	@RequestMapping("/uploadImg")
	public void uploadImg(@RequestParam("img") CommonsMultipartFile img, HttpServletRequest request) throws Exception {
		String extName = "";

		// TODO 配置文件配置
		String realPath = "D:\\Java\\Jizuz\\repo\\Jizuz\\Jizuz\\src\\main\\resources\\static\\img\\photos";
		logger.debug("real path is : {}", realPath);

		String imgFileName = img.getOriginalFilename();
		// File oldFile = new File(imgFileName);
		if (StringUtil.isNotEmpty(imgFileName) && imgFileName.lastIndexOf(".") > 0) {
			// 获取扩展名,如:".jpg"
			extName = imgFileName.substring(imgFileName.lastIndexOf("."));
			logger.debug("extend name is : {}", extName);
		}
		// 获取当前时间,格式化成"yyyyMMddHHmmss"
		String currentTime = DateUtil.getCurrentDate2String(DateUtil.DATETIME_FORMAT_2);
		// 获取3位随机数字符串
		String rand = RandomUtil.getRandomString("0123456789", 3);
		String newPictureName = "IMG_" + currentTime + rand + extName;
		logger.debug("the new picture name is : {}", newPictureName);

		String pathName = realPath + SymbolConstant.DIAGONAL + newPictureName;
		logger.debug(pathName);
		// oldFile.renameTo(new File(pathName));

		request.setAttribute("pathName", pathName);
	}

}

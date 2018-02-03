package com.zshoon.jizuz.controller.photograph;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSON;
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
	 *〈进入图片展示页面〉
	 *
	 * @param model
	 * @return String
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

	/**
	 *〈上传图片〉
	 * @param img
	 * @param request
	 * @author Jizuz
	 * @throws Exception
	 */
	@RequestMapping("/uploadImg")
	public void uploadImg(@RequestParam("Filedata")MultipartFile img, HttpServletRequest request) throws Exception {
		String extName = "";
		HttpSession session = request.getSession();
//		session.removeAttribute("pathName");

		// TODO 配置文件配置
//		String realPath = "img/photos";
		String realPath = "D:\\Java\\Jizuz\\repo\\Jizuz\\Jizuz\\src\\main\\resources\\static\\img\\photos";
		logger.debug("real path is : {}", realPath);
		File file = new File(realPath);
		if (!file.exists()) {
			// 创建文件夹
			file.mkdirs();
		}

		String imgFileName = img.getOriginalFilename();
		if (StringUtil.isNotEmpty(imgFileName) && imgFileName.lastIndexOf(".") > 0) {
			// 获取扩展名,如:".jpg"
			extName = imgFileName.substring(imgFileName.lastIndexOf("."));
			logger.debug("extend name is : {}", extName);
		}

		String currentTime = DateUtil.getCurrentDate2String(DateUtil.DATETIME_FORMAT_2);
		// 获取3位随机数字符串
		String rand = RandomUtil.getRandomString("0123456789", 3);
		String newPictureName = "IMG_" + currentTime + rand + extName;
		logger.debug("the new picture name is : {}", newPictureName);

		String pathName = realPath + SymbolConstant.DIAGONAL + newPictureName;
		logger.debug(pathName);
		FileCopyUtils.copy(img.getBytes(), new File(pathName));
		
		session.setAttribute("pathName", pathName);
	}
	
	/**
	 *〈添加图片〉
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addImg")
	public String addImage(HttpServletRequest request) {
		String themeId = request.getParameter("imgTheme");
		String comments = request.getParameter("imgComment");
		
		PhotoDto dto = new PhotoDto();
		dto.setTid(Long.valueOf(themeId));
		dto.setComments(comments);
		dto.setPath(String.valueOf(request.getSession().getAttribute("pathName")));
		
		boolean ret = photoService.addImage(dto);
		
		return (ret)?JSON.toJSONString("success"):"error";
	}

}

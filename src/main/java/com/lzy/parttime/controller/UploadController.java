package com.lzy.parttime.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author j_cxn
 * @description : [上传图片]
 *
 * @时间: 2017年11月10日 上午10:25:08
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping("/uploadPic")
	public void uploadPic(MultipartFile pic,HttpServletRequest request, HttpServletResponse response){
		JSONObject jsonObject = new JSONObject();
		try {
			// 图片改名
			String filename = pic.getOriginalFilename();
			 // 后缀   无"."
			String suffix = FilenameUtils.getExtension(filename);
			//uuid,给上传图片重新起名字
			String uuid = UUID.randomUUID().toString().replace("-", "");
			String newName = uuid + "." + suffix;
			//照片大小
			long size = pic.getSize();
			if(size>=1048576){
				jsonObject.put("msg", "图片过大");
				jsonObject.put("code", 500); // 保存图片地址
			}else{
				String realPath = "D:\\imagesuuuu\\";
				String imgUrl = realPath + newName; // 相对路径
				// 上传
				pic.transferTo(new File(imgUrl));
				
				// 回显图片
				jsonObject.put("allUrl", "../images/"+newName);
				jsonObject.put("imgUrl", "../images/"+newName); // 保存图片地址
				jsonObject.put("code", 1000); // 保存图片地址
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().write(jsonObject.toString());
			}
		} catch (Exception e) {//异常处理
			try {
				jsonObject.put("code", 500); // 保存图片地址
				jsonObject.put("msg", "图片过大");
				e.printStackTrace();
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}

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

@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping("/uploadPic")
	public void uploadPic(MultipartFile pic,HttpServletRequest request, HttpServletResponse response){
		JSONObject jsonObject = new JSONObject();
		try {
			// 图片改名
			String filename = pic.getOriginalFilename();
			String suffix = FilenameUtils.getExtension(filename); // 后缀   无"."
			String uuid = UUID.randomUUID().toString().replace("-", "");
			String newName = uuid + "." + suffix;
			
			long size = pic.getSize();
			if(size>=1048576){
				jsonObject.put("msg", "图片过大");
				jsonObject.put("code", 500); // 保存图片地址
			}else{
				// 图片上传。
				//String realPath = request.getSession().getServletContext().getRealPath(""); // 项目的真实路径
				
				
//				File file = new File(realPath,"upload");  
//				if (!file.exists()) {  
//					file.mkdirs();  
//				}  
//				String imgUrl = "\\upload\\" + newName; // 相对路径
//				
//				String allUrl = realPath + imgUrl;
				
				
				String realPath = "C:\\Users\\admin\\Desktop\\parttime\\src\\main\\resources\\static\\images\\";
				String imgUrl = realPath + newName; // 相对路径
				// 上传
				pic.transferTo(new File(imgUrl));
				
				//String realPaths = "D:\\cxn-file\\Spring-Tool-Data\\seek\\src\\main\\resources\\static\\images\\";
				//String imgUrls = realPath + newName;
				//pic.transferTo(new File(imgUrls));
				
				// 回显图片
				jsonObject.put("allUrl", "../images/"+newName);
				jsonObject.put("imgUrl", "../images/"+newName); // 保存图片地址
				jsonObject.put("code", 1000); // 保存图片地址
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().write(jsonObject.toString());
			}
		} catch (Exception e) {
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

package com.lzy.parttime.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lzy.parttime.entity.User;
import com.lzy.parttime.service.LoginService;
import com.lzy.parttime.utils.CheckUtil;
import com.lzy.parttime.utils.Result;

/**
 * 
 * @author 李兆阳
 * @description : [登录入口]
 *
 * @时间: 2017年10月20日 上午9:43:13
 */
@RestController
@Controller
public class LoginController {

	@Resource
	private LoginService loginService;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	/**
	 * @TODO: [登录验证]
	 * @createTime:2017年10月20日下午4:59:36
	 */
	@RequestMapping(value = "/doLogin")
	public Map<String, Object> loginIndex(User user ) {
		Map<String, Object> map = new HashMap<>();
		Result result =  loginService.doLogin(user);
		return CheckUtil.returnResult(map,result.getCode(), result.getMsg(), "");
	}
	
	/**
	 * 
	 * @TODO: [登录首页]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/index" )
	public ModelAndView loginIndex(){
		return new ModelAndView("index");
	}
	
	/**
	 * 
	 * @TODO: [主页]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/main" )
	public ModelAndView main(){
		return new ModelAndView("main");
	}
}

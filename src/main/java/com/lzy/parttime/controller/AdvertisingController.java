package com.lzy.parttime.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lzy.parttime.entity.Advertising;
import com.lzy.parttime.service.AdvertisingService;
import com.lzy.parttime.utils.CheckUtil;
import com.lzy.parttime.utils.Result;

/**
 * 
 * @author 李兆阳
 * @description : [广告controller层]
 *
 * @时间: 2017年10月19日 上午11:02:30
 */
@Controller
@RequestMapping("advertising")
public class AdvertisingController {

	@Resource
	private AdvertisingService advertisingService;
	
	/**
	 * 
	 * @TODO: [广告管理页面]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/advertisingIndex" )
	public ModelAndView advertisingIndex(Integer id){
		//跳转页面
		return new ModelAndView("advertising_Index");
	}
	
	/**
	 * @TODO: [广告列表]
	 * @createTime:2017年10月23日下午3:30:09
	 */
	@RequestMapping("/findAdvertisingList")
	public @ResponseBody Map<String, Object> findAdvertisingList(int companyId,String name,int pageIndex, int pageSize){
		Map<String, Object> map = advertisingService.findAdvertisingList(companyId,name,pageIndex,pageSize);
		//返回列表数据,map封装
		return map;
	}
	
	/**
	 * 
	 * @TODO: [广告编辑页面]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/editAdvertisingIndex" )
	public ModelAndView editAdvertisingIndex(Integer id){
		ModelAndView mv = new ModelAndView();
		//要返回的页面:advertising_edit页面
		mv.setViewName("advertising_edit");
		return mv;
	}
	
	/**
	 * 
	 * @TODO: [通过id查询广告]
	 * @createTime:2017年10月24日下午8:32:57
	 */
	@RequestMapping(value = "/getgetAdvertisingById" )
	public @ResponseBody Map<String, Object> getgetAdvertisingById(Integer id){
		Map<String, Object> map = new HashMap<>();
		//result中封装了code: 常量用来定义返回状态的,msg 返回消息,data :返货数据
		Result result = advertisingService.getgetAdvertisingById(id);
		//返回结果集
		return CheckUtil.returnResult(map,result.getCode(), result.getMsg(), result.getData());
	}
	
	
	/**
	 * 
	 * @TODO: [编辑广告]
	 * @param company
	 * @return: 
	 * @createTime:2017年10月24日下午8:04:45
	 */
	@RequestMapping(value = "/editAdvertising" )
	public @ResponseBody Map<String, Object> editAdvertising(Advertising advertising){
		Map<String, Object> map = new HashMap<>();
		//result中封装了code: 常量用来定义返回状态的,msg 返回消息,data :返货数据
		Result result = advertisingService.editAdvertising(advertising);
		//返回结果集
		return CheckUtil.returnResult(map,result.getCode(), result.getMsg(), "");
	}
	
	/**
	 * 
	 * @TODO: [添加广告首页面]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/addAdvertisingIndex" )
	public ModelAndView addAdvertisingIndex(){
		//跳转页面
		return new ModelAndView("advertising_add");
	}
	
	/**
	 * 
	 * @TODO: [添加广告]
	 * @return: 
	 * @createTime:2017年10月24日下午6:51:09
	 */
	@RequestMapping(value = "/saveAdvertising" )
	public @ResponseBody Map<String, Object> saveAdvertising(Advertising advertising){
		Map<String, Object> map = new HashMap<>();
		Result result = advertisingService.saveAdvertising(advertising);
		return CheckUtil.returnResult(map,result.getCode(), result.getMsg(), "");
	}
	
	/**
	 * 
	 * @TODO: [删除广告]
	 * @param company
	 * @return: 
	 * @createTime:2017年10月24日下午8:04:45
	 */
	@RequestMapping(value = "/delAdvertisingById" )
	public @ResponseBody Map<String, Object> delAdvertisingById(Integer id){
		Map<String, Object> map = new HashMap<>();
		// result中封装了code: 常量用来定义返回状态的,msg 返回消息,data :返货数据
		Result result = advertisingService.delAdvertisingById(id);
		//返回结果集
		return CheckUtil.returnResult(map,result.getCode(), result.getMsg(), "");
	}
}

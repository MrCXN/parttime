package com.lzy.parttime.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lzy.parttime.entity.Company;
import com.lzy.parttime.service.CompanyService;
import com.lzy.parttime.utils.CheckUtil;
import com.lzy.parttime.utils.Result;

/**
 * 
 * @author 李兆阳
 * @description : [公司controller层]
 *
 * @时间: 2017年10月19日 上午11:02:30
 */
@Controller
@RequestMapping("company")
public class CompanyController {

	@Resource
	private CompanyService companyService;//service接口
	
	/**
	 * 
	 * @TODO: [公司管理页面]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/companyIndex" )
	public ModelAndView companyIndex(){
		//返回company_Index页面
		return new ModelAndView("company_Index");
	}
	/**
	 * 
	 * @TODO: [招聘人员列表页面]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/seekUserIndex" )
	public ModelAndView seekUserIndex(){
		//返回seekUser_index页面
		return new ModelAndView("seekUser_index");
	}
	
	/**
	 * @TODO: [公司列表]
	 * @createTime:2017年10月23日下午3:30:09
	 */
	@RequestMapping("/findCompanyList")
	public @ResponseBody Map<String, Object> findCompanyList(String addTime,String name,int pageIndex, int pageSize){
		//返回公司列表集合,用map封装
		Map<String, Object> map = companyService.findCompanyList(addTime,name,pageIndex,pageSize);
		return map;
	}
	
	/**
	 * @TODO: [人员列表]
	 * @createTime:2017年10月23日下午3:30:09
	 */
	@RequestMapping("/findSeekUserList")
	public @ResponseBody Map<String, Object> findSeekUserList(String name,int pageIndex, int pageSize){
		//返回人员列表集合
		Map<String, Object> map = companyService.findSeekUserList(name,pageIndex,pageSize);
		return map;
	}
	
	/**
	 * 
	 * @TODO: [公司编辑页面]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/editCompanyIndex" )
	public ModelAndView editIndex(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("company_edit");
		//返回company_edit页面
		return mv;
	}
	/**
	 * 
	 * @TODO: [添加公司首页面]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/addCompanyIndex" )
	public ModelAndView addIndex(){
		//返回company_add页面
		return new ModelAndView("company_add");
	}
	/**
	 * 
	 * @TODO: [添加公司]
	 * @return: 
	 * @createTime:2017年10月24日下午6:51:09
	 */
	@RequestMapping(value = "/saveCompany" )
	public @ResponseBody Map<String, Object> saveCompany(Company company){
		//company 页面传给后台的公司信息
		Map<String, Object> map = new HashMap<>();
		//添加公司, 返回result,result中封装了code: 常量用来定义返回状态的,msg 返回消息,data :返货数据
		Result result = companyService.saveCompany(company);
		//返回结果集
		return CheckUtil.returnResult(map,result.getCode(), result.getMsg(), "");
	}
	/**
	 * 
	 * @TODO: [通过id查询公司]
	 * @param company
	 * @return: 
	 * @createTime:2017年10月24日下午8:32:57
	 */
	@RequestMapping(value = "/getCompanyById" )
	public @ResponseBody Map<String, Object> getCompanyById(Integer id){
		//id 公司id
		Map<String, Object> map = new HashMap<>();
		//查询公司
		Result result = companyService.getCompanyById(id);
		//返回查询结果,返回结果集
		return CheckUtil.returnResult(map,result.getCode(), result.getMsg(), result.getData());
	}
	/**
	 * 
	 * @TODO: [删除公司]
	 * @param company
	 * @return: 
	 * @createTime:2017年10月24日下午8:04:45
	 */
	@RequestMapping(value = "/delCompanyById" )
	public @ResponseBody Map<String, Object> delCompanyById(Integer id){
		//公司id
		Map<String, Object> map = new HashMap<>();
		//删除公司信息, 这里的删除不是真正的删除, 只是更改了公司中标志为的状态
		Result result = companyService.delCompanyById(id);
		//返回删除结果
		return CheckUtil.returnResult(map,result.getCode(), result.getMsg(), "");
	}
	/**
	 * 
	 * @TODO: [删除人员]
	 * @param company
	 * @return: 
	 * @createTime:2017年10月24日下午8:04:45
	 */
	@RequestMapping(value = "/delSeekUserById" )
	public @ResponseBody Map<String, Object> delSeekUserById(Integer id){
		//人员id
		Map<String, Object> map = new HashMap<>();
		//删除人员, 这里的删除只是更改了人员的标志位
		Result result = companyService.delSeekUserById(id);
		//返回删除结果
		return CheckUtil.returnResult(map,result.getCode(), result.getMsg(), "");
	}
	
	/**
	 * 
	 * @TODO: [编辑公司]
	 * @param company
	 * @return: 
	 * @createTime:2017年10月24日下午8:04:45
	 */
	@RequestMapping(value = "/editCompanyById" )
	public @ResponseBody Map<String, Object> editCompanyById(Company company){
		//company 公司信息
		Map<String, Object> map = new HashMap<>();
		//编辑公司
		Result result = companyService.editCompanyById(company);
		//返回编辑结果
		return CheckUtil.returnResult(map,result.getCode(), result.getMsg(), "");
	}
	
}

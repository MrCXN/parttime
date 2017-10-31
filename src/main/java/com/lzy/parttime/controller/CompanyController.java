package com.lzy.parttime.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	private CompanyService companyService;
	
	/**
	 * 
	 * @TODO: [公司管理页面]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/companyIndex" )
	public ModelAndView companyIndex(){
		return new ModelAndView("company_Index");
	}
	
	/**
	 * @TODO: [公司列表]
	 * @createTime:2017年10月23日下午3:30:09
	 */
	@RequestMapping("/findCompanyList")
	public @ResponseBody Map<String, Object> findCompanyList(String addTime,String name,int pageIndex, int pageSize){
		Map<String, Object> map = companyService.findCompanyList(addTime,name,pageIndex,pageSize);
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
		return mv;
	}
	/**
	 * 
	 * @TODO: [添加公司首页面]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/addCompanyIndex" )
	public ModelAndView addIndex(){
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
		Map<String, Object> map = new HashMap<>();
		Result result = companyService.saveCompany(company);
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
		Map<String, Object> map = new HashMap<>();
		Result result = companyService.getCompanyById(id);
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
		Map<String, Object> map = new HashMap<>();
		Result result = companyService.delCompanyById(id);
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
		Map<String, Object> map = new HashMap<>();
		Result result = companyService.editCompanyById(company);
		return CheckUtil.returnResult(map,result.getCode(), result.getMsg(), "");
	}
	
}

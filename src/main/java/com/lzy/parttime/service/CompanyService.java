package com.lzy.parttime.service;

import java.util.Map;

import com.lzy.parttime.entity.Company;
import com.lzy.parttime.utils.Result;

/**
 * 
 * @author 李兆阳
 * @description : [公司业务层接口]
 *
 * @时间: 2017年10月19日 上午11:05:13
 */
public interface CompanyService {

	/**
	 * 
	 * @TODO: [公司列表]
	 * @param addTime : 添加时间
	 * @param name : 公司名称
	 * @param pageIndex : 当前页
	 * @param pageSize : 页数
	 * @return: 
	 * @createTime:2017年10月23日下午3:34:08
	 */
	Map<String, Object> findCompanyList(String addTime, String name, int pageIndex, int pageSize);

	/**
	 * 
	 * @TODO: [添加公司]
	 * @param company
	 * @return: 
	 * @createTime:2017年10月24日下午6:58:55
	 */
	Result saveCompany(Company company);

	/**
	 * 
	 * @TODO: [删除公司]
	 * @param id
	 * @return: 
	 * @createTime:2017年10月24日下午8:05:42
	 */
	Result delCompanyById(Integer id);

	/**
	 * 
	 * @TODO: [通过id查询公司]
	 * @param id
	 * @return: 
	 * @createTime:2017年10月24日下午8:33:41
	 */
	Result getCompanyById(Integer id);

	/**
	 * 
	 * @TODO: [编辑公司]
	 * @param company
	 * @return: 
	 * @createTime:2017年10月25日下午7:00:33
	 */
	Result editCompanyById(Company company);

}

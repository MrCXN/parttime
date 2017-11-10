package com.lzy.parttime.service;

import java.util.Map;

import com.lzy.parttime.entity.Advertising;
import com.lzy.parttime.utils.Result;

/**
 * 
 * @author CXN
 * @description : [广告业务层接口]
 *
 * @时间: 2017年10月25日 下午7:45:55
 */
public interface AdvertisingService {

	/**
	 * 
	 * @TODO: [列表]
	 * @param name
	 * @param pageIndex
	 * @param pageSize
	 * @return: 
	 * @createTime:2017年10月25日下午8:09:24
	 */
	Map<String, Object> findAdvertisingList(int companyId,String name, int pageIndex, int pageSize);

	/**
	 * 
	 * @TODO: [添加广告]
	 * @param advertising
	 * @return: 
	 * @createTime:2017年10月25日下午8:09:18
	 */
	Result saveAdvertising(Advertising advertising);

	/**
	 * 
	 * @TODO: [通过id查询广告]
	 * @param id
	 * @return: 
	 * @createTime:2017年10月25日下午8:30:15
	 */
	Result getgetAdvertisingById(Integer id);

	/**
	 * 
	 * @TODO: [编辑广告]
	 * @param advertising
	 * @return: 
	 * @createTime:2017年10月25日下午8:43:36
	 */
	Result editAdvertising(Advertising advertising);

	/**
	 * 
	 * @TODO: [删除广告]
	 * @param id
	 * @return: 
	 * @createTime:2017年10月25日下午8:47:19
	 */
	Result delAdvertisingById(Integer id);

}

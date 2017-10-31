package com.lzy.parttime.dao;

import java.util.List;
import java.util.Map;

import com.lzy.parttime.entity.Advertising;
/**
 * 
 * @author CXN
 * @description : [广告数据库接口]
 *
 * @时间: 2017年10月25日 下午7:50:19
 */
public interface AdvertisingDao {

	/**
	 * 
	 * @TODO: [广告集合]
	 * @param params
	 * @return: 
	 * @createTime:2017年10月25日下午7:50:01
	 */
	List<Advertising> findAdvertisingList(Map<String, Object> params);

	/**
	 * 
	 * @TODO: [广告数量]
	 * @param params
	 * @return: 
	 * @createTime:2017年10月25日下午7:50:08
	 */
	int findAdvertisingListCount(Map<String, Object> params);

	/**
	 * 
	 * @TODO: [添加广告]
	 * @param params: 
	 * @createTime:2017年10月25日下午8:11:58
	 */
	void saveAdvertising(Map<String, Object> params);

	/**
	 * 
	 * @TODO: [通过id查询广告]
	 * @param params
	 * @return: 
	 * @createTime:2017年10月25日下午8:31:58
	 */
	Advertising getgetAdvertisingById(Map<String, Object> params);

	/**
	 * 
	 * @TODO: [编辑广告]
	 * @param params: 
	 * @createTime:2017年10月25日下午8:45:17
	 */
	void editAdvertising(Map<String, Object> params);

	/**
	 * 
	 * @TODO: [删除广告]
	 * @param params: 
	 * @createTime:2017年10月25日下午8:48:06
	 */
	void delAdvertisingById(Map<String, Object> params);

}

package com.lzy.parttime.dao;

import java.util.Map;

import com.lzy.parttime.entity.User;

/**
 * 
 * @author 李兆阳
 * @description : [登录数据接口]
 *
 * @时间: 2017年10月19日 上午11:06:32
 */
public interface LoginDao {

	/**
	 * 
	 * @param params 
	 * @TODO: [登录验证]
	 * @return: user
	 * @createTime:2017年10月23日上午9:20:37
	 */
	User getLoginUser(Map<String, Object> params);

}

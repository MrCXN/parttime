package com.lzy.parttime.service;

import com.lzy.parttime.entity.User;
import com.lzy.parttime.utils.Result;

/**
 * 
 * @author 李兆阳
 * @description : [登录业务层接口]
 *
 * @时间: 2017年10月19日 上午11:05:13
 */
public interface LoginService {

	/**
	 * 
	 * @TODO: [登录验证]
	 * @createTime:2017年10月20日下午5:16:35
	 */
	Result doLogin(User user);
	
}

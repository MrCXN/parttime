package com.lzy.parttime.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.lzy.parttime.dao.LoginDao;
import com.lzy.parttime.entity.User;
import com.lzy.parttime.service.LoginService;
import com.lzy.parttime.utils.AESCoder;
import com.lzy.parttime.utils.CodeConstant;
import com.lzy.parttime.utils.ErrorCode;
import com.lzy.parttime.utils.Result;

/**
 * 
 * @author 李兆阳
 * @description : [登录业务实现类]
 *
 * @时间: 2017年10月19日 上午11:04:48
 */
@Service("loginService")  
public class LoginServiceImpl implements LoginService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private LoginDao loginDao;

	/*
	 * @TODO: [登录验证]
	 * @下午5:16:55
	 * @see com.lzy.parttime.service.LoginService#doLogin(com.lzy.parttime.entity.User)
	 */
	@Override
	public Result doLogin(User user) {
		Result result = new Result();
		result.setMsg("加载成功");
		result.setCode(CodeConstant.CODE1000);
		Map<String, Object> params = new HashMap<>();
		params.put("userAccount", user.getUserAccount());
		try {
			User verifyUser = loginDao.getLoginUser(params);
			if(verifyUser==null){
				result.setCode(CodeConstant.CODE201);
				result.setMsg("用户不存在");
				return result;
			}
			if(!new String(AESCoder.decode(verifyUser.getPwd())).equals(user.getPwd())){
				result.setCode(CodeConstant.CODE202);
				result.setMsg("账户密码不匹配，请重新输入");
				return result;
			}
		} catch (Exception e) {
			result.setCode(CodeConstant.CODE200);
			result.setMsg("加载失败");
			log.error("\r\n 登录验证 ： errorcode=" + ErrorCode.geterrocode(this)+",user:"+user
			+ "  \r\n" + e + "\r\n\r\n");
			e.printStackTrace();
		}
		return result;
	}
}

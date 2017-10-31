package com.lzy.parttime.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzy.parttime.dao.CompanyDao;
import com.lzy.parttime.entity.Company;
import com.lzy.parttime.entity.User;
import com.lzy.parttime.service.CompanyService;
import com.lzy.parttime.utils.AESCoder;
import com.lzy.parttime.utils.CodeConstant;
import com.lzy.parttime.utils.DateUtil;
import com.lzy.parttime.utils.ErrorCode;
import com.lzy.parttime.utils.Result;

/**
 * 
 * @author 李兆阳
 * @description : [公司业务实现类]
 *
 * @时间: 2017年10月19日 上午11:04:48
 */
@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

	Logger log = Logger.getLogger(this.getClass());
	@Resource
	private CompanyDao companyDao;

	/*
	 * @TODO: [公司列表]
	 * @下午3:34:41
	 * @see com.lzy.parttime.service.CompanyService#findCompanyList(java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public Map<String, Object> findCompanyList(String addTime, String name, int pageIndex, int pageSize) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("msg", "查询成功");
		Map<String, Object> params = new HashMap<>();
		params.put("name",name);
		params.put("addTime",addTime);
		params.put("pageIndex",(pageIndex - 1) * pageSize);
		params.put("pageSize",pageSize);
		try {
			List<Company> list = companyDao.getCompanyList(params);
			map.put("list", list);
			int count = companyDao.getCompanyListCount(params);
			map.put("count", count);
			return map;
		} catch (Exception e) {
			map.put("code", CodeConstant.CODE200);
			map.put("msg", "查询失败");
			log.error("\r\n 公司列表查询 ： errorcode=" + ErrorCode.geterrocode(this)
			+ "  \r\n" + e + "\r\n" + ",addTime:" + addTime+ ",name:" + name + "\r\n\r\n");
			e.printStackTrace();
		}
		return map;
	}

	/*
	 * @TODO: [添加公司]
	 * @下午6:59:30
	 * @see com.lzy.parttime.service.CompanyService#saveCompany(com.lzy.parttime.entity.Company)
	 */
	@Override
	public Result saveCompany(Company company) {
		Result result = new Result();
		result.setMsg("加载成功");
		result.setCode(CodeConstant.CODE1000);
		Map<String, Object> params = new HashMap<>();
		params.put("name",company.getName());
		params.put("type",company.getType());
		params.put("introduce",company.getIntroduce());
		params.put("imgUrl",company.getImgUrl());
		params.put("addTime",DateUtil.getDate(new Date()));
		try {
			companyDao.insertCompany(params);
		} catch (Exception e) {
			result.setCode(CodeConstant.CODE200);
			result.setMsg("加载失败");
			log.error("\r\n 添加公司 ： errorcode=" + ErrorCode.geterrocode(this)+",company:"+company
			+ "  \r\n" + e + "\r\n\r\n");
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * @TODO: [删除公司]
	 * @下午8:06:09
	 * @see com.lzy.parttime.service.CompanyService#delCompanyById(java.lang.Integer)
	 */
	@Override
	public Result delCompanyById(Integer id) {
		Result result = new Result();
		result.setMsg("加载成功");
		result.setCode(CodeConstant.CODE1000);
		Map<String, Object> params = new HashMap<>();
		params.put("id",id);
		try {
			companyDao.delCompanyById(params);
		} catch (Exception e) {
			result.setCode(CodeConstant.CODE200);
			result.setMsg("加载失败");
			log.error("\r\n 删除公司 ： errorcode=" + ErrorCode.geterrocode(this)+",id:"+id
			+ "  \r\n" + e + "\r\n\r\n");
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * @TODO: [通过id查询公司]
	 * @下午8:34:01
	 * @see com.lzy.parttime.service.CompanyService#getCompanyById(java.lang.Integer)
	 */
	@Override
	public Result getCompanyById(Integer id) {
		Result result = new Result();
		result.setMsg("加载成功");
		result.setCode(CodeConstant.CODE1000);
		Map<String, Object> params = new HashMap<>();
		params.put("id",id);
		try {
			Company company = companyDao.getCompanyById(params);
			result.setData(company);
		} catch (Exception e) {
			result.setCode(CodeConstant.CODE200);
			result.setMsg("加载失败");
			log.error("\r\n 通过id查询公司： errorcode=" + ErrorCode.geterrocode(this)+",id:"+id
			+ "  \r\n" + e + "\r\n\r\n");
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * @TODO: [编辑公司]
	 * @下午7:01:06
	 * @see com.lzy.parttime.service.CompanyService#editCompanyById(com.lzy.parttime.entity.Company)
	 */
	@Override
	public Result editCompanyById(Company company) {
		Result result = new Result();
		result.setMsg("加载成功");
		result.setCode(CodeConstant.CODE1000);
		Map<String, Object> params = new HashMap<>();
		params.put("id",company.getId());
		params.put("name",company.getName());
		params.put("type",company.getType());
		params.put("introduce",company.getIntroduce());
		params.put("imgUrl",company.getImgUrl());
		try {
			companyDao.updateCompanyById(params);
			result.setData(company);
		} catch (Exception e) {
			result.setCode(CodeConstant.CODE200);
			result.setMsg("加载失败");
			log.error("\r\n 编辑公司： errorcode=" + ErrorCode.geterrocode(this)+",company:"+company
			+ "  \r\n" + e + "\r\n\r\n");
			e.printStackTrace();
		}
		return result;
	}
	
}

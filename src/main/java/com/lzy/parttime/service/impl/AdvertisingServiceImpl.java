package com.lzy.parttime.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzy.parttime.dao.AdvertisingDao;
import com.lzy.parttime.entity.Advertising;
import com.lzy.parttime.entity.Company;
import com.lzy.parttime.service.AdvertisingService;
import com.lzy.parttime.utils.CodeConstant;
import com.lzy.parttime.utils.ErrorCode;
import com.lzy.parttime.utils.Result;

/**
 * 
 * @author 李兆阳
 * @description : [广告业务实现类]
 *
 * @时间: 2017年10月19日 上午11:04:48
 */
@Service("advertisingService")
@Transactional
public class AdvertisingServiceImpl implements AdvertisingService {

	Logger log = Logger.getLogger(this.getClass());
	@Resource
	private AdvertisingDao advertisingDao;

	/*
	 * @TODO: [广告列表]
	 * 
	 * @下午3:34:41
	 * 
	 * @see
	 * com.lzy.parttime.service.CompanyService#findCompanyList(java.lang.String,
	 * java.lang.String, int, int)
	 */
	@Override
	public Map<String, Object> findAdvertisingList(int companyId, String name, int pageIndex, int pageSize) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("msg", "查询成功");
		Map<String, Object> params = new HashMap<>();
		params.put("name", name);
		params.put("companyId", companyId);
		params.put("pageIndex", (pageIndex - 1) * pageSize);
		params.put("pageSize", pageSize);
		try {
			List<Advertising> list = advertisingDao.findAdvertisingList(params);
			map.put("list", list);
			int count = advertisingDao.findAdvertisingListCount(params);
			map.put("count", count);
			return map;
		} catch (Exception e) {
			map.put("code", CodeConstant.CODE200);
			map.put("msg", "查询失败");
			log.error("\r\n 广告列表 ： errorcode=" + ErrorCode.geterrocode(this) + "  \r\n" + e + "\r\n" + ",name:" + name
					+ "\r\n\r\n");
			e.printStackTrace();
		}
		return map;
	}

	/*
	 * @TODO: [添加广告]
	 * 
	 * @下午6:59:30
	 * 
	 * @see
	 * com.lzy.parttime.service.CompanyService#saveCompany(com.lzy.parttime.
	 * entity.advertising)
	 */
	@Override
	public Result saveAdvertising(Advertising advertising) {
		Result result = new Result();
		result.setMsg("加载成功");
		result.setCode(CodeConstant.CODE1000);
		Map<String, Object> params = new HashMap<>();
		params.put("name", advertising.getName());
		params.put("salary", advertising.getSalary());
		params.put("sex", advertising.getSex());
		params.put("age", advertising.getAge());
		params.put("companyId", advertising.getCompanyId());
		try {
			advertisingDao.saveAdvertising(params);
		} catch (Exception e) {
			result.setCode(CodeConstant.CODE200);
			result.setMsg("加载失败");
			log.error("\r\n 添加广告 ： errorcode=" + ErrorCode.geterrocode(this) + ",advertising:" + advertising + "  \r\n"
					+ e + "\r\n\r\n");
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * @TODO: [通过id查询广告]
	 * @下午8:31:28
	 * @see com.lzy.parttime.service.AdvertisingService#getgetAdvertisingById(java.lang.Integer)
	 */
	@Override
	public Result getgetAdvertisingById(Integer id) {
		Result result = new Result();
		result.setMsg("加载成功");
		result.setCode(CodeConstant.CODE1000);
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		try {
			Advertising advertising = advertisingDao.getgetAdvertisingById(params);
			result.setData(advertising);
		} catch (Exception e) {
			result.setCode(CodeConstant.CODE200);
			result.setMsg("加载失败");
			log.error("\r\n 通过id查询广告： errorcode=" + ErrorCode.geterrocode(this) + ",id:" + id + "  \r\n" + e
					+ "\r\n\r\n");
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * @TODO: [编辑广告]
	 * @下午7:01:06
	 * @see com.lzy.parttime.service.CompanyService#editCompanyById(com.lzy.parttime.entity.advertising)
	 */
	@Override
	public Result editAdvertising(Advertising advertising) {
		Result result = new Result();
		result.setMsg("加载成功");
		result.setCode(CodeConstant.CODE1000);
		Map<String, Object> params = new HashMap<>();
		params.put("id",advertising.getId());
		params.put("name", advertising.getName());
		params.put("salary", advertising.getSalary());
		params.put("sex", advertising.getSex());
		params.put("age", advertising.getAge());
		params.put("companyId", advertising.getCompanyId());
		try {
			advertisingDao.editAdvertising(params);
		} catch (Exception e) {
			result.setCode(CodeConstant.CODE200);
			result.setMsg("加载失败");
			log.error("\r\n 编辑广告： errorcode=" + ErrorCode.geterrocode(this)+",advertising:"+advertising
			+ "  \r\n" + e + "\r\n\r\n");
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * @TODO: [删除广告]
	 * @下午8:06:09
	 * @see com.lzy.parttime.service.CompanyService#delCompanyById(java.lang.Integer)
	 */
	@Override
	public Result delAdvertisingById(Integer id) {
		Result result = new Result();
		result.setMsg("加载成功");
		result.setCode(CodeConstant.CODE1000);
		Map<String, Object> params = new HashMap<>();
		params.put("id",id);
		try {
			advertisingDao.delAdvertisingById(params);
		} catch (Exception e) {
			result.setCode(CodeConstant.CODE200);
			result.setMsg("加载失败");
			log.error("\r\n 删除广告 ： errorcode=" + ErrorCode.geterrocode(this)+",id:"+id
			+ "  \r\n" + e + "\r\n\r\n");
			e.printStackTrace();
		}
		return result;
	}

}

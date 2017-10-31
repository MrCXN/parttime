package com.lzy.parttime.utils;

public interface CodeConstant {

	public static final int CODE500 = 500;//参数缺少
	public static final int CODE200 = 200;//错误
	public static final int CODE1000 = 1000;//数据获取成功
	public static final int CODE201 = 201;//登陆账户不存在
	public static final int CODE202 = 202;//密码错误
	public static final int CODE203 = 203;//账户未设置权限
	public static final int CODE204 = 204;//用户单角色
	public static final int CODE205 = 205;//用户多角色
	public static final int CODE206 = 206;//用户没有对应的角色
	public static final int CODE207 = 207;//帐号不正确
	public static final int CODE208 = 208;//密码不正确
	public static final int CODE209 = 209;//库存不足
	public static final int CODE210 = 210;//有作业组未提交需求
	public static final int CODE211 = 211;//查找集合为空
	public static final int CODE212 = 212;//成功
	public static final int CODE213 = 213;//集采库存不足
	public static final int CODE214 = 214;//账单为空
	
	public static final String CODE1000_SUCCESS = "数据获取成功";
	public static final String CODE1000_UPDATESUCCESS = "数据更新成功";
	
	
	public static final String NAV_1001 = "nav_1001";// 待办任务
	
	public static final String NAV_1 = "nav_1";//基础信息
	public static final String NAV_101 = "nav_101";//基础信息--角色
	public static final String NAV_102 = "nav_102";//基础信息--组织架构
	public static final String NAV_103 = "nav_103";//基础信息--人员管理
	public static final String NAV_104 = "nav_104";//基础信息--物料分类
	public static final String NAV_105 = "nav_105";//基础信息--物料单位
	public static final String NAV_106 = "nav_106";//基础信息--物料
	
	public static final String NAV_2 = "nav_2";//餐饮中心设置
	public static final String NAV_201 = "nav_201";//餐饮中心设置--餐饮中心物料设置
	public static final String NAV_202 = "nav_202";//餐饮中心设置--供应商物料设置
	public static final String NAV_203 = "nav_203";//餐饮中心设置--物料价格设置
	public static final String NAV_204 = "nav_204";//餐饮中心设置--供应商管理
	public static final String NAV_205 = "nav_205";//餐饮中心设置--客户管理
	public static final String NAV_206 = "nav_206";//餐饮中心设置--临时物料管理
	public static final String NAV_207 = "nav_207";//配送中心设置--标签管理
	public static final String NAV_208 = "nav_208";//配送中心设置--供应商管理
	public static final String NAV_209 = "nav_209";//配送中心设置--关联管理
	
	public static final String NAV_3 = "nav_3";//申报管理
	public static final String NAV_301 = "nav_301";//申报管理--分拣单
	public static final String NAV_302 = "nav_302";//申报管理--模板
	
	public static final String NAV_4 = "nav_4";//采购单
	public static final String NAV_401 = "nav_401";//采购单--集采采购单
	public static final String NAV_402 = "nav_402";//采购单--地采采购单
	
	public static final String NAV_5 = "nav_5";//入库单
	public static final String NAV_501 = "nav_501";//入库单--集采入库单
	public static final String NAV_502 = "nav_502";//入库单--地采入库单
	public static final String NAV_503 = "nav_503";//入库单--集采退货单
	
	public static final String NAV_6 = "nav_6";//客户信息
	public static final String NAV_601 = "nav_601";//客户信息--客户管理
	
	public static final String NAV_7 = "nav_7";//出库单
	public static final String NAV_701 = "nav_701";//出库单--集采出库单
	public static final String NAV_702 = "nav_702";//出库单--地采出库单
	public static final String NAV_703 = "nav_703";//出库单--集采退库单
	
	public static final String NAV_8 = "nav_8";//库存管理
	public static final String NAV_801 = "nav_801";//库存管理--库存修正
	public static final String NAV_802 = "nav_802";//库存管理--临时物料库存修正
	public static final String NAV_803 = "nav_803";//库存管理--库存查询
	public static final String NAV_804 = "nav_804";//库存管理--临时物料库存查询
	
	public static final String NAV_9 = "nav_9"; //单据搜索
	public static final String NAV_901 = "nav_901";//单据搜索--搜索
}

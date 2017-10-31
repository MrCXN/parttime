package com.lzy.parttime.utils;

/**
 * CallResult code
 * @author yanghaibo
 * @date 2017/1/5.
 */
public enum ResultEnum {

    /* 以下是基础码 */
    SERVER_ERROR(-1, "系统异常"),
    SUCCESS(1, "成功"),
    NO_ACCESS(301, "无此权限"),
    UNLOGIN(302, "未登录"),
    UNFOLLOW(303, "请先关注云享付公众号"),
    PARAM_ERROR(400, "参数异常"),
    CENTER_ERROR(510, "中心异常"),
    SESSION_ERROR(710, "session异常"),
    TOKEN_ERROR(810, "无效的token,请重试"),

    // 数据库操作读写失败
    DATABASE_ERROR(101, "execute Database Operate failed!"),
    // 未获取到数据
    NOT_FOUND_DATA_ERROR(102, "can not found the data!"),
    // 数据重复错误
    EXITSTS_DATA_ERROR(103, "the Data already exists!"),

    /* 以下是业务错误码 四位*/
    DEVICE_INVALID(1001, "设备未激活"),
    DEVICE_GUID_INVALID(1002, "GUID无效"),
   
    D_APP_NOTEXIST(2000, "APP不存在"),
    D_APP_INVALID(2001, "查询app版本为空"),
    D_APPHOTFIX_INVALID(2002, "查询app热修复版本为空"),

    /*上报异常错误码*/
    EXC_REPORT_REPEAT(30400, "异常已上报"),
    EXC_STACK_BLANK(30401, "异常堆栈为空"),
    EXC_MD5_BLANK(30402, "上报信息异常"),
    EXC_EXCEPTION(30404, "未获取异常信息"),
    EXC_EXCEPTION_DETAIL(30405, "保存异常信息详情错误"),
    ;
    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return this.code;
    }

    public String msg() {
        return this.msg;
    }
}

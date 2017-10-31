package com.lzy.parttime;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author 李兆阳
 * @description : [springBoot启动入口]
 *
 * @时间: 2017年10月19日 上午10:59:36
 */
@SpringBootApplication
@MapperScan("com.lzy.parttime.dao")
public class ParttimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParttimeApplication.class, args);
	}
}

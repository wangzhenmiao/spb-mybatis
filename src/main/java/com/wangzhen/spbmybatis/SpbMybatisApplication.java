package com.wangzhen.spbmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//指定数据访问接口的包名
@MapperScan("com.wangzhen.spbmybatis.repository")
public class SpbMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpbMybatisApplication.class, args);
	}

}


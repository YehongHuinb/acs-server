package com.sw.acs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 周良聪
 */
@SpringBootApplication
@MapperScan(basePackages = "com.sw.acs.mapper")
public class AcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcsApplication.class, args);
	}

}

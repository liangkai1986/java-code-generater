package com.smartwater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @auther kai.liang
 * @create 2019-05-17 11:55
 * @Description
 * @Version 1.0
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.smartwater.javacode.dao")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}

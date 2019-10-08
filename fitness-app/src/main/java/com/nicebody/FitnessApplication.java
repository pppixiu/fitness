package com.nicebody;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ClassName FitnessApplication
 * @Author sensu
 * @Date 2019/9/15 20:40
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.nicebody.mapper")
@ServletComponentScan
public class FitnessApplication {
    public static void main(String[] args) {
        SpringApplication.run(FitnessApplication.class, args);
    }
}

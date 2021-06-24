package com.gdou.gms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

// @MapperScan("com.gdou.gms.mapper")：扫描指定路径的mapper接口，在运行时通过动态代理生成实现类

@EnableAsync
@SpringBootApplication
@MapperScan("com.gdou.gms.mapper")
public class GdouGmsApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(GdouGmsApplication.class, args);
    }

}

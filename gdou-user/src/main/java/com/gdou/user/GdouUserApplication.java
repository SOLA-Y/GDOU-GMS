package com.gdou.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gdou.user.mapper")
public class GdouUserApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(GdouUserApplication.class, args);
    }

}

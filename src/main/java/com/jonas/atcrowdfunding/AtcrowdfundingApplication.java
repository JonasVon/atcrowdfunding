package com.jonas.atcrowdfunding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.jonas.atcrowdfunding.mapper")
@SpringBootApplication
public class AtcrowdfundingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtcrowdfundingApplication.class, args);
    }

}

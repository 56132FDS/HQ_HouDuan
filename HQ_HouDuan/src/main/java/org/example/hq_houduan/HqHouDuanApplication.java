package org.example.hq_houduan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.hq_houduan.mapper")
public class HqHouDuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(HqHouDuanApplication.class, args);
    }

}

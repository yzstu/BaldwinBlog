package cn.yzstu.baldwinblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.yzstu.baldwinblog.mapper")
public class BaldwinblogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaldwinblogApplication.class, args);
    }
}

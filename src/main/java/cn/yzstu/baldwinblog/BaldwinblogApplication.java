package cn.yzstu.baldwinblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableCaching
@MapperScan("cn.yzstu.baldwinblog.mapper")
@ComponentScan(basePackages = {"cn.yzstu.common", "cn.yzstu.baldwinblog"})
public class BaldwinblogApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(BaldwinblogApplication.class, args);
    }


}

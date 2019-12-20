package cn.yzstu.baldwinblog;

import cn.yzstu.baldwinblog.filter.LoginInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
@MapperScan("cn.yzstu.baldwinblog.mapper")
@ComponentScan(basePackages = {"cn.yzstu.common", "cn.yzstu.baldwinblog"})
public class BaldwinblogApplication extends WebMvcConfigurerAdapter {

    @Autowired
    private LoginInterceptor loginInterceptor;

    public static void main(String[] args) {
        SpringApplication.run(BaldwinblogApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/css/**");
        excludePath.add("/font/**");
        excludePath.add("/font-awesome/**");
        excludePath.add("/image/**");
        excludePath.add("/js/**");
        excludePath.add("/layui/**");
        excludePath.add("/login/**");
        excludePath.add("/error");
        excludePath.add("/favicon.ico");
        excludePath.add("/*.html");
        //registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(excludePath);
    }
}

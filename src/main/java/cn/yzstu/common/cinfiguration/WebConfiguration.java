package cn.yzstu.common.cinfiguration;

import cn.yzstu.baldwinblog.filter.LoginInterceptor;
import cn.yzstu.baldwinblog.filter.WebIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2019/12/12
 * \* Time: 16:47
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加不需要过滤的路=路径
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/css/**");
        excludePath.add("/font/**");
        excludePath.add("/font-awesome/**");
        excludePath.add("/image/**");
        excludePath.add("/js/**");
        excludePath.add("/layui/**");
        excludePath.add("/error");


        /*registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(excludePath);*/
        registry.addInterceptor(new WebIntercepter()).addPathPatterns("/").excludePathPatterns(excludePath);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //添加静态资源swagger-ui.html的扫描路径，否则无法打开swagger-UI
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
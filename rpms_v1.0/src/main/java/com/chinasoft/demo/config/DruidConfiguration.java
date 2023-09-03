package com.chinasoft.demo.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Druid数据源的配置类
 * 被@Configuration注解修饰的类都是配置类，配置类等价于SSM框架的配置文件
 * SpringBoot启动的时候会将配置类里面的Bean对象注入到Spring容器中
 * 此时需要配置两个Bean对象
 * 1 Druid数据源监控的Servlet对象
 * 2 Druid数据源过滤器对象
 */
@Configuration
@Slf4j
public class DruidConfiguration {

    /**
     * @Bean注解等价于XML配置文件的<bean></bean>节点，程序启动的时候会将@Bean对应的方法返回值注入到Spring容器中
     * 将性能监控的Servlet对象(StatViewServlet)通过ServletRegistrationBean注入到Spring容器
     * 步骤如下：
     * 1 创建ServletRegistrationBean对象，将StatViewServlet和映射的URL注入该对象里面
     * 2 设置Druid连接池的用户名、密码、白名单、是否允许充值刷新等信息
     * 3 返回ServletRegistrationBean对象
     * @return ServletRegistrationBean 是一个Servlet注册器，唯一职责是将Servlet注入到Spring容器中
     * 注意：StatViewServlet对用是Servlet的子类，用来处理Druid性能监控和统计请求的
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> createServletRegistrationBean() {
        // 参数1： StatViewServlet对象通过ServletRegistrationBean注册器注入到Spring容器
        // 参数2： "/druid/*" 表示StatViewServlet映射的URL，此时会处理/druid路径和所有子路径的请求
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        // 配置性能监控的参数
        Map<String,String> initParamsMap = new ConcurrentHashMap<>();
        initParamsMap.put("loginUsername","admin");
        initParamsMap.put("loginPassword","admin");
        // 白名单：所有的地址
        initParamsMap.put("allow","");
        // 不启用充值刷新
        initParamsMap.put("resetEnable","false");
        bean.setInitParameters(initParamsMap);
        return bean;
    }

    /**
     * 将Druid监控的注册器(WebStatFilter)通过FilterRegistrationBean对象注入到Spring容器
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> createFilterRegistrationBean(){

//        log.info("FilterRegistrationBean start create");
        FilterRegistrationBean<WebStatFilter> filterBean = new FilterRegistrationBean<>(new WebStatFilter());
//        log.info("FilterRegistrationBean create success "+filterBean);
        // 拦截所有的请求
        filterBean.addUrlPatterns("/*");
        // 但是会自动排除下面的请求
        filterBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return  filterBean;
    }
}

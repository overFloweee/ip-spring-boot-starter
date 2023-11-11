package cn.hjw.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration(proxyBeanMethods = true)
public class SpringMvcConfig implements WebMvcConfigurer
{

    @Autowired
    private IpCountInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {

        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }
}

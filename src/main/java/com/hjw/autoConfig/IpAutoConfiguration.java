package com.hjw.autoConfig;

import com.hjw.properties.IpProperties;
import com.hjw.service.impl.IpCountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // 开启定时任务
// @EnableConfigurationProperties(IpProperties.class)
@Import(IpProperties.class)
public class IpAutoConfiguration
{
    @Bean
    public IpCountServiceImpl ipCountService()
    {
        return new IpCountServiceImpl();
    }

}

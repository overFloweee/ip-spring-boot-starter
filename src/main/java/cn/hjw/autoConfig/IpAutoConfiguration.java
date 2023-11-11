package cn.hjw.autoConfig;

import cn.hjw.properties.IpProperties;
import cn.hjw.service.impl.IpCountServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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

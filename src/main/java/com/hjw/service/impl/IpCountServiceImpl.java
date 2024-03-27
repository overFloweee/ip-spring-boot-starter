package com.hjw.service.impl;

import com.hjw.properties.IpProperties;
import com.hjw.service.IpCountService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;

// @Component
public class IpCountServiceImpl implements IpCountService
{
    @Autowired
    // 当前request对象的注入工作 由使用当前 starter 的工程提供自动装配
    private HttpServletRequest request;
    private Map<String, Integer> ipCountMap = new HashMap<>();

    @Autowired
    private IpProperties ipProperties;


    public void count()
    {
        // 每次调用该方法，就累计访问次数
        System.out.println("-------------------------------------");

        // 1、获取当前操作的ip地址
        String ip = request.getRemoteAddr();
        // 2、根据ip地址从map中取出 次数 ，并递增
        Integer count = ipCountMap.get(ip);
        if (count == null)
        {
            ipCountMap.put(ip, 1);
        }
        else
        {
            ipCountMap.put(ip, count + 1);
        }
    }


    @Scheduled(cron = "0/#{ipProperties.cycle} * * * * ?")
    public void print()
    {
        if (ipProperties.getModel().equalsIgnoreCase(IpProperties.LogModel.DETAIL.getVaule()))
        {
            System.out.println("        IP访问监控");
            System.out.println("+-------ip-address----+---num----+");
            for (Map.Entry<String, Integer> entry : ipCountMap.entrySet())
            {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(String.format("|%17s    |%7d   |", key, value));

            }
            System.out.println("+---------------------+----------+");

        }
        else if (ipProperties.getModel().equalsIgnoreCase(IpProperties.LogModel.SIMPLE.getVaule()))
        {
            System.out.println("        IP访问监控");
            System.out.println("+-------ip-address----+");
            for (String key : ipCountMap.keySet())
            {
                System.out.println(String.format("|%17s    |", key));

            }
            System.out.println("+---------------------+");

        }


        if (ipProperties.getCycleReset())
        {
            ipCountMap.clear();
        }

    }

}

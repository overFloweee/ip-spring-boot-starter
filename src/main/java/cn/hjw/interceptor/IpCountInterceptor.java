package cn.hjw.interceptor;

import cn.hjw.service.impl.IpCountServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class IpCountInterceptor implements HandlerInterceptor
{

    @Autowired
    private IpCountServiceImpl ipCountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        ipCountService.count();
        return true;
    }

}

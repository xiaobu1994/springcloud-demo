package com.xiaobu.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2018/11/7 14:28
 * @description V1.0 zuul过滤器
 */
@Component
@Slf4j
public class MyFilter extends ZuulFilter {
    /**
     * @author xiaobu
     * @date 2018/11/7 14:57
     * @return java.lang.String
     * @descprition pre：路由之前  routing：路由之时 post： 路由之后 error：发送错误调用
     * @version 1.0
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * @author xiaobu
     * @date 2018/11/7 15:01
     * @return int
     * @descprition   过滤的顺序
     * @version 1.0
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * @author xiaobu
     * @date 2018/11/7 14:59
     * @return boolean
     * @descprition  true表示为需要过滤
     * @version 1.0
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request=requestContext.getRequest();
        String token=request.getParameter("token");
        //字符串替换替换
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        if(StringUtils.isBlank(token)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().setContentType("text/html;charset=UTF-8");
                requestContext.getResponse().getWriter().print("令牌是空的。");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        log.info("ok");
        return null;
    }
}
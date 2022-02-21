package xyz.lazyrabbit.sentinel.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.common.util.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class MySentinelExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        log.info("rule:{}", e.getRule());
        // 自定义返回结果
        Response responseObj = null;
        if (e instanceof FlowException) {
            // 限流
            responseObj = ResponseUtils.failure("接口限流");
        } else if (e instanceof DegradeException) {
            // 降级
            responseObj = ResponseUtils.failure("服务降级");
        } else if (e instanceof ParamFlowException) {
            // 热点参数
            responseObj = ResponseUtils.failure("热点参数限流");
        } else if (e instanceof SystemBlockException) {
            // 系统保护
            responseObj = ResponseUtils.failure("触发系统保护规则");
        } else if (e instanceof AuthorityException) {
            // 授权规则
            responseObj = ResponseUtils.failure("授权规则不通过");
        }
        //返回json数据
        httpServletResponse.setStatus(200);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        //springmvc 的一个json转换类 （jackson）
        new ObjectMapper().writeValue(httpServletResponse.getWriter(), responseObj);
        //重定向
        //response.sendRedirect("http://www.baidu.com");
    }
}

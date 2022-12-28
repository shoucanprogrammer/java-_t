package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@FeignClient(value = "service-ucenter")
@Component
public interface CommentClient {
    @DeleteMapping(value = "/educenter/member/getMemberInfo")
    public Map<String,String> getMemberInfo1(HttpServletRequest request) ;
}

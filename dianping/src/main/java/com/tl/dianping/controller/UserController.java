package com.tl.dianping.controller;

import cn.hutool.core.bean.BeanUtil;
import com.tl.dianping.dto.LoginFormDTO;
import com.tl.dianping.dto.Result;
import com.tl.dianping.dto.UserDTO;
import com.tl.dianping.entity.User;
import com.tl.dianping.entity.UserInfo;
import com.tl.dianping.service.IUserInfoService;
import com.tl.dianping.service.IUserService;
import com.tl.dianping.utils.UserHolder;
import io.swagger.annotations.ApiImplicitParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @Resource
    private IUserInfoService userInfoService;

    /**
     * 发送手机验证码
     */
    @PostMapping("code")
    public Result sendCode(@RequestParam("phone") String phone, HttpSession session) {
        // 发送短信验证码并保存验证码
        return userService.sendCode(phone, session);
    }


    /**
     * 登录功能
     * @param loginForm 登录参数，包含手机号、验证码；或者手机号、密码
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginFormDTO loginForm, HttpSession session){
        // 实现登录功能
        return userService.login(loginForm, session);
    }

    /**
     * 登出功能
     * @return 无
     */
    @PostMapping("/logout")
    public Result logout(){
        // TODO 实现登出功能
        return Result.fail("功能未完成");
    }

    @GetMapping("/me")
    public Result me(){
        // 获取当前登录的用户并返回
        UserDTO user = UserHolder.getUser();
        return Result.ok(user);
    }

    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Long userId){
        // 查询详情
        UserInfo info = userInfoService.getById(userId);
        if (info == null) {
            // 没有详情，应该是第一次查看详情
            return Result.ok();
        }
        info.setCreateTime(null);
        info.setUpdateTime(null);
        // 返回
        return Result.ok(info);
    }

    @GetMapping("/{id}")
    public Result queryUserById(@PathVariable("id") Long userId){
        // 查询详情
        User user = userService.getById(userId);
        if (user == null) {
            return Result.ok();
        }
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        // 返回
        return Result.ok(userDTO);
    }
    @ApiImplicitParam(name = "Authorization", value = "32b2f93daefd422e840551ed5d929698",required = true, dataType = "String",paramType="header")
    @PostMapping("/sign")
    public Result sign(){
        return userService.sign();
    }


    @ApiImplicitParam(name = "Authorization", value = "32b2f93daefd422e840551ed5d929698",required = true, dataType = "String",paramType="header")
    @GetMapping("/sign/count")
    public Result signCount(){
        return userService.signCount();
    }
}
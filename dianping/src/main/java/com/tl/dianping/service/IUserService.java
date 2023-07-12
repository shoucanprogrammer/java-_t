package com.tl.dianping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tl.dianping.dto.LoginFormDTO;
import com.tl.dianping.dto.Result;
import com.tl.dianping.entity.User;
import com.tl.dianping.dto.LoginFormDTO;
import com.tl.dianping.dto.Result;
import com.tl.dianping.entity.User;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IUserService extends IService<User> {

    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);

    Result sign();

    Result signCount();

}

package com.tl.dianping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tl.dianping.dto.Result;
import com.tl.dianping.entity.Follow;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IFollowService extends IService<Follow> {

    Result follow(Long followUserId, Boolean isFollow);

    Result isFollow(Long followUserId);

    Result followCommons(Long id);
}

package com.tl.dianping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tl.dianping.dto.Result;
import com.tl.dianping.entity.ShopType;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IShopTypeService extends IService<ShopType> {

    Result queryList();
}

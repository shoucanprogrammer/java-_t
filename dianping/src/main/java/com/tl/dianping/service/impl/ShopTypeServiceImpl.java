package com.tl.dianping.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tl.dianping.dto.Result;
import com.tl.dianping.entity.ShopType;
import com.tl.dianping.mapper.ShopTypeMapper;
import com.tl.dianping.service.IShopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public Result queryList() {
        List<String> shopTypesList = redisTemplate.opsForList().range("shop:list", 0, -1);
        if (CollectionUtil.isNotEmpty(shopTypesList)){
            String s = shopTypesList.get(0);
            List<ShopType> types = JSONUtil.toList(shopTypesList.get(0), ShopType.class);
            return Result.ok(types);
        }
        //查库
        QueryWrapper<ShopType> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");
        //把分页数据封装到pageTeacher对象
        List<ShopType> shopTypes = baseMapper.selectList(wrapper);
        if (CollectionUtil.isEmpty(shopTypes)){
            return Result.fail("店铺不存在");
        }
        //list 存
        String jsonStr = JSONUtil.toJsonStr(shopTypes);
        redisTemplate.opsForList().leftPushAll("shop:list",jsonStr);
        return Result.ok(shopTypes);
    }

}

package com.tl.dianping.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tl.dianping.dto.Result;
import com.tl.dianping.entity.Shop;
import com.tl.dianping.service.IShopService;
import com.tl.dianping.utils.SystemConstants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Resource
    public IShopService shopService;

    /**
     * 根据id查询商铺信息
     */
    @GetMapping("{id}")
    public Result queryShopById(@PathVariable("id") Long id){

        return shopService.queryById(id);
    }
    /*
    更新
     */
    @GetMapping
    public Result updateShop(@RequestBody Shop shop){
        //写入数据库
        shopService.update(shop);
        return Result.ok();
    }
    @GetMapping("/of/type")
    public Result queryShopByType(
            @RequestParam("typeId") Integer typeId,
            @RequestParam(value = "current", defaultValue = "1") Integer current,
            @RequestParam(value = "x", required = false) Double x,
            @RequestParam(value = "y", required = false) Double y
    ) {
        return shopService.queryShopByType(typeId, current, x, y);
    }

    /**
     * 根据商铺名称关键字分页查询商铺信息
     * @param name 商铺名称关键字
     * @param current 页码
     * @return 商铺列表
     */
    @GetMapping("/of/name")
    public Result queryShopByName(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "current", defaultValue = "1") Integer current
    ) {
        // 根据类型分页查询
        Page<Shop> page = shopService.query()
                .like(StrUtil.isNotBlank(name), "name", name)
                .page(new Page<>(current, SystemConstants.MAX_PAGE_SIZE));
        // 返回数据
        return Result.ok(page.getRecords());
    }

}

package com.atguigu.educms.controller;


import com.atguigu.commonutils.R;
import com.atguigu.educms.entity.CrmBanner;
import com.atguigu.educms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-12-09
 */
@RestController
@RequestMapping("/educms/crmadmin")
@CrossOrigin
public class BannerAdminController {
    @Autowired
    private CrmBannerService bannerService;
    //1 分页查询banner

    @GetMapping("pageBanner/{page}/{limit}")
    public R pageBanner(@PathVariable long page, @PathVariable long limit){
        Page<CrmBanner> crmBannerPage = new Page<>(page,limit);
        bannerService.page(crmBannerPage,null);
        return R.ok().data("items",crmBannerPage.getRecords())
                .data("total",crmBannerPage.getTotal());
    }
    //2 添加banner
    @PostMapping("addBanner")
    public R addBanner(@RequestBody CrmBanner crmBanner){
        bannerService.save(crmBanner);
        return R.ok();
    }

    @ApiOperation(value = "获取Banner")
    @GetMapping("get/{id}")
    public R getById(@PathVariable String id){
        CrmBanner crmBanner = bannerService.getById(id);
        return R.ok().data("item",crmBanner);
    }

    @ApiOperation(value = "修改Banner")
    @PutMapping("update")
    public R update(@RequestBody CrmBanner crmBanner){
        bannerService.updateById(crmBanner);
        return R.ok();
    }

    @ApiOperation(value = "删除Banner")
    @DeleteMapping("remove/{id}")
    public R removeById(@PathVariable String id){
        bannerService.removeById(id);
        return R.ok();
    }

}


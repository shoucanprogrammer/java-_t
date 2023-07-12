package com.atguigu.staservice.service.impl;


import com.atguigu.staservice.client.UcenterClient;
import com.atguigu.staservice.entity.StatisticsDaily;
import com.atguigu.staservice.mapper.StatisticsDailyMapper;
import com.atguigu.staservice.service.StatisticsDailyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-12-24
 */
@Service
public class StatisticsDailyServiceImpl extends ServiceImpl<StatisticsDailyMapper, StatisticsDaily> implements StatisticsDailyService {

    @Autowired
    private UcenterClient ucenterClient;
    @Override
    public void registerCount(String day) {
        //删除直接统计的数据，重新统计
        QueryWrapper<StatisticsDaily> wrapper = new QueryWrapper<>();
        wrapper.eq("date_calculated",day);
        baseMapper.delete(wrapper);
        //重新统计
        //远程调用
        Integer countRegister =(Integer) ucenterClient.countRegister(day).getData().get("countRegister");
        //把获取数据添加数据库，统计分析表里面
        StatisticsDaily sta = new StatisticsDaily();
        sta.setRegisterNum(countRegister); //注册人数
        sta.setDateCalculated(day);//统计日期

        sta.setVideoViewNum(RandomUtils.nextInt(100,200));
        sta.setLoginNum(RandomUtils.nextInt(100,200));
        sta.setCourseNum(RandomUtils.nextInt(100,200));
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        sta.setGmtCreate(date);
        sta.setGmtModified(date);
        baseMapper.insert(sta);
    }

    @Override
    public Map<String, Object> getShowData(String type, String begin, String end) {

        QueryWrapper<StatisticsDaily> wrapper = new QueryWrapper();
        wrapper.between("date_calculated",begin,end);
        wrapper.select("date_calculated",type);
        List<StatisticsDaily> staList = baseMapper.selectList(wrapper);

        List<Integer> numDataList = new ArrayList<>();
        List<String> dateList = new ArrayList<>();

        for (int i = 0; i < staList.size(); i++){
            StatisticsDaily daily = staList.get(i);
            dateList.add(daily.getDateCalculated());
            switch (type){
                case "login_num":
                    numDataList.add(daily.getLoginNum());
                    break;
                case "register_num":
                    numDataList.add(daily.getRegisterNum());
                    break;
                case "video_view_num":
                    numDataList.add(daily.getVideoViewNum());
                    break;
                case "course_num":
                    numDataList.add(daily.getCourseNum());
                    break;
                default:
                    break;
            }

        }
        //把封装之后两个list集合放到map集合，进行返回
        Map<String, Object> map = new HashMap<>();
        map.put("date_calculatedList",dateList);
        map.put("numDataList",numDataList);
        return map;

    }
}

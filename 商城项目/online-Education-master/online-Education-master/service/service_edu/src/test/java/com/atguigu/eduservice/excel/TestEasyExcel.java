package com.atguigu.eduservice.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {
    //写操作
//    public static void main(String[] args) {
//        //实现excel写操作
//        //1.设置写入文件地址和exccel文件名称
//        String filename="E:\\liaoxiaoyue.xlsx";
//
//        //2.调用easyecxel里面的方法实现写操作
//        EasyExcel.write(filename,DemoData.class).sheet("廖晓悦").doWrite(getData());
//    }

    //读操作
    public static void main(String[] args) {
        String filename = "E:\\write.xlsx";
        EasyExcel.read(filename, DemoData.class, new ExcelListener()).sheet().doRead();
    }

    private static List<DemoData> getData() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            DemoData data = new DemoData();
            data.setSid(i + 1);
            data.setSname("廖晓悦是猪：" + "我同意" + i);
            list.add(data);
        }
        return list;
    }
}

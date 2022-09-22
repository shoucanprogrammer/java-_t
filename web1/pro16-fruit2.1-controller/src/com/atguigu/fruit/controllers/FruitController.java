package com.atguigu.fruit.controllers;


import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.myspringmvc.ViewBaseServlet;
import com.atguigu.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class FruitController extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAOImpl();

    private String update(Integer fid, String fname, Integer price, Integer fcount, String remark, HttpServletRequest request) {

        fruitDAO.updateFruit(new Fruit(fid,fname, price ,fcount ,remark ));
        //4.资源跳转
        //super.processTemplate("index",request,response);
        //request.getRequestDispatcher("index.html").forward(request,response);
        //此处需要重定向，目的是重新给IndexServlet发请求，重新获取furitList，然后覆盖到session中，这样index.html页面上显示的session中的数据才是最新的
//        response.sendRedirect("fruit.do");
        return "reditect:fruit.do";
    }


    private String edit(Integer fid, HttpServletRequest request ){

        if(fid != null){
            Fruit fruit = fruitDAO.getFruitByFid(fid);
            request.setAttribute("fruit",fruit);
//            super.processTemplate("edit",request,response);
            return "edit";
        }
        return "error";
    }

    private String del(Integer fid, HttpServletRequest request ){

        if(fid != null){
            fruitDAO.delFruitByFid(fid);
            //super.processTemplate("index",request,response);
            return "redirect:fruit.do";
        }
        return "error";
    }

    private String add(String fname, Integer price, Integer fcount, String remark,HttpServletRequest request) throws  IOException {
        request.setCharacterEncoding("UTF-8");
        Fruit fruit = new Fruit(0,fname , price , fcount , remark ) ;

        fruitDAO.addFruit(fruit);

//        response.sendRedirect("fruit.do");

        return "redirect:fruit.do";
    }

    private String index(String oper, String keyword, Integer pageNo, HttpServletRequest request ) {
        HttpSession session = request.getSession() ;
        if (pageNo == null){
            pageNo = 1;
        }

        if(StringUtil.isNOtEmpty(oper) && "search".equals(oper)){
            pageNo = 1 ;
            //如果keyword为null，需要设置为空字符串""，否则查询时会拼接成 %null% , 我们期望的是 %%
            if(StringUtil.isEmpty(keyword)){
                keyword = "" ;
            }
            //将keyword保存（覆盖）到session中
            session.setAttribute("keyword",keyword);
        }else{

            //如果不是点击的查询按钮，那么查询是基于session中保存的现有keyword进行查询
            Object keywordObj = session.getAttribute("keyword");
            if(keywordObj!=null){
                keyword = (String)keywordObj ;
            }else{
                keyword = "" ;
            }
        }
        // 重新更新当前页的值
        session.setAttribute("pageNo",pageNo);

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitListByPage(keyword , pageNo);
        session.setAttribute("fruitList",fruitList);
        //总记录条数
        int fruitCount = fruitDAO.getFruitCount(keyword);
        //总页数
        int pageCount = (fruitCount+5-1)/5 ;
        session.setAttribute("pageCount",pageCount);
        return "index";
    }
}

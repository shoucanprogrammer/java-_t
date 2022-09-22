package com.atguigu.fruit.servlets;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.myspringmvc.ViewBaseServlet;
import com.atguigu.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//Servlet从3.0版本开始支持注解方式的注册
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {
        Integer pageNo = 1;
        String pageNostr = request.getParameter("pageNo");
        if (StringUtil.isNOtEmpty(pageNostr)){
            pageNo = Integer.parseInt(pageNostr);
        }
        HttpSession session = request.getSession();
        session.setAttribute("pageNo",pageNo);
        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitListByPage(pageNo);
        //保存到session作用域
        session.setAttribute("fruitList",fruitList);
        int fruitCount = fruitDAO.getFruitCount();
        int pageCount ;
        if (fruitCount%5==0){
            pageCount = fruitCount / 5;
        }else {
            pageCount = fruitCount / 5 +1;
        }
        session.setAttribute("pageCount",pageCount);
        //此处的视图名称是 index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称 ：   index
        //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
        //所以真实的视图名称是：      /       index       .html
        super.processTemplate("index",request,response);
    }
}

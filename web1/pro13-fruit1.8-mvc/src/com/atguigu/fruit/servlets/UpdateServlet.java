package com.atguigu.fruit.servlets;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String fidStr = req.getParameter("fid");
        int fid = Integer.parseInt(fidStr);
        String fname = req.getParameter("fname");
        String priceStr = req.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = req.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);
        String remark = req.getParameter("remark");
        fruitDAO.updateFruit(new Fruit(fid,fname,price,fcount,remark));

//        //手动覆盖
//        List<Fruit> fruitList = fruitDAO.getFruitList();
//        //保存到session作用域
//        HttpSession session = req.getSession() ;
//        session.setAttribute("fruitList",fruitList);
//        资源跳转
//        服务器内部转换，list还是旧的list
//        super.processTemplate("index",req,resp);
        //此处需要重定向，目的是重新给IndexServlet发请求，重新获取furitList，然后覆盖seesion中
        resp.sendRedirect("index");

    }
}

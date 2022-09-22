package servlets;

import fruit.dao.FruitDAO;
import fruit.dao.impl.FruitDAOImpl;
import fruit.pojo.Fruit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        Integer price = Integer.parseInt(priceStr);
        String fcountstr = request.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountstr);
        String remark = request.getParameter("remark");

        System.out.println("fname="+fname);
        System.out.println("price="+price);
        System.out.println("fcount="+fcount);
        System.out.println("remark="+remark);

        FruitDAO fruitDAO = new FruitDAOImpl();
        boolean flag = fruitDAO.addFruit(new Fruit(0,fname,price,fcount,remark));
        System.out.println(flag?"true":"false");

    }

}

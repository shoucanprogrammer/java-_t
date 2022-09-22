package com.atguigu.myssm.myspringmvc;

import com.atguigu.myssm.ioc.BeanFactory;
import com.atguigu.myssm.util.StringUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@WebServlet("*.do")
public class DispatcherServlet extends ViewBaseServlet{
    private BeanFactory beanFactory;
    public DispatcherServlet(){}

    public void init() throws ServletException {
        super.init();
        //之前是在此处注定创建IOC容器
        //现在优化为从application作用域去获取
//        beanFactory = new ClassPathXmlApplicationContext();
        ServletContext application = getServletContext();
        Object beanFactoryObj = application.getAttribute("beanFactory");
        if (beanFactoryObj != null){
            beanFactory = (BeanFactory) beanFactoryObj;
        }else {
            throw new RuntimeException("IOC容器获取失败");
        }

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        //     /hello.do
        //字符串截取
        servletPath = servletPath.substring(1);
        int lasDotIndex = servletPath.lastIndexOf(".do");
        servletPath = servletPath.substring(0,lasDotIndex);
        System.out.println(servletPath);
        Object controllerBeanObj = beanFactory.getBean(servletPath);
        String operate = req.getParameter("operate");
        if (StringUtil.isEmpty(operate)){
            operate = "index";
        }
        try {
            Method[] methods = controllerBeanObj.getClass().getDeclaredMethods();
            for (Method method : methods){
                if (operate.equals(method.getName())){
                    //1.统一获取请求参数
                    //获取当前方法的参数数组，返回参数数组
                    Parameter[] parameters = method.getParameters();
                    //paramterValuese 用来承载参数的值
                    Object[] parameterValues = new Object[parameters.length];
                    for (int i = 0; i < parameters.length; i++){
                        Parameter parameter = parameters[i];
                        String parameterName = parameter.getName();
                        if ("request".equals(parameterName)){
                            parameterValues[i] = req;
                        }else if ("response".equals(parameterName)){
                            parameterValues[i] = resp;
                        }else if ("session".equals(parameterName)){
                            parameterValues[i] = req.getSession();
                        }else {
                            //从请求中获取参数值
                            String parameterValue = req.getParameter(parameterName);
                            String typeName = parameter.getType().getName();
                            Object parameterObj = null;
                            parameterObj = parameterValue;
                            if (parameterObj != null)
                                if ("java.lang.Integer".equals(typeName)){
                                    parameterObj = Integer.parseInt(parameterValue);
                                }
                            parameterValues[i] = parameterObj;
                        }
                    }
                    //2.controller组件中的方法调用
                    method.setAccessible(true);
                    Object returnObj = method.invoke(controllerBeanObj,parameterValues);

                    //3.视图处理
                    String methodReturnStr = (String) returnObj;
                    if (methodReturnStr.startsWith("redirect")){// 比如：redire：fruit.do
                        String redirectStr = methodReturnStr.substring("redirect:".length());
                        resp.sendRedirect(redirectStr);
                    }else {
                        super.processTemplate(methodReturnStr,req,resp);//比如:"edit"
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new DispatcherServletException("DispatcherServlet出错了");
        }

//        Method[] methods = controllerBeanObj.getClass().getDeclaredMethods();
//        for (Method m : methods){
//            String methodName = m.getName();
//            if (operate.equals(methodName)){
//                try {
//                    m.invoke(this,req,resp);
//                    return;
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                } catch (InvocationTargetException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//        throw new RuntimeException("operate值非法");
    }
}
//常见错误 IllegalArgumentException: argument type mismatch
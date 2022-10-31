package spring5.Proxy;

import spring5.dao.UserDao;
import spring5.dao.impl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKKProxy {
    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
//        Proxy.newProxyInstance(JDKKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao =(UserDao)Proxy.newProxyInstance(JDKKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int add = dao.add(1, 2);
        System.out.println("result"+add);
    }
}
//创建代理对象代码
class UserDaoProxy implements InvocationHandler{
    //1 把创建的是谁的代理对象，把谁传递过来
    //有参数构造传递
    private Object obj;
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }
    //增强逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("method before:"+ method.getName()+":ars:"+Arrays.toString(args));
        //被增强的方法执行
        Object res = method.invoke(obj,args);
        //方法之后
        System.out.println("method after:"+obj);
        return null;
    }
}


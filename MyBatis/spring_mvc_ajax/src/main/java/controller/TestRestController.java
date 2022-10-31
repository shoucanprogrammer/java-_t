package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 查询所有的用户信息-->/user-->get
 * 根据id查询所有的用户信息-->/user/1-->get
 * 添加用户信息-->/user-->post
 *修改用户信息-->/user--put
 * 删除用户信息用户信息-->/user/1-->delete
 *
 * 注意：浏览器目前只能发送get和post请求
 * 若要发送put和delete请求，需要在web.xml中配置一个过滤器HiddenHttpMethodFilter
 *1.当前请求必须为post
 * 2.当前请求必须传输参数_method，_method的值才是最终的请求方式
 */
@Controller
public class TestRestController {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有的用户信息-->/user-->get");
        return "success";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getByIdUser(@PathVariable("id") Integer id){
        System.out.println("根据id查询所有的用户信息-->/user/"+id+"-->get");
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(){
        System.out.println("添加用户信息-->/user-->post");
        return "success";
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("添加用户信息-->/user-->put");
        return "success";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("删除用户信息用户信息-->/user/"+id+"-->delete");
        return "success";
    }

}

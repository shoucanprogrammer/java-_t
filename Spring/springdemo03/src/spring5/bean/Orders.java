package spring5.bean;

public class Orders {
    private String oname;

    public Orders() {
        System.out.println("1 creat bean");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("2 set");
    }

    //创建执行的初始化方法
    public void initMethod(){
        System.out.println("3 init");
    }

    public void destroyMethod(){
        System.out.println("5 destroyMethod");
    }
}

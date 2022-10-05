package spring5.bean;

public class Dept {
    //部门类
    private String dname;
    public void setDname(String dname){
        this.dname = dname;

    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}

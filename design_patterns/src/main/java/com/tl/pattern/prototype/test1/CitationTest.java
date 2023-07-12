package com.tl.pattern.prototype.test1;

import java.io.*;

public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        //1 创建原型对象
        Citation citation = new Citation();
        Student stu = new Student();
        stu.setName("张三");
        citation.setStudent(stu);
        //创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G:\\OneDrive - hdu.edu.cn\\JAVA\\design_patterns\\src\\main\\java\\com\\tl\\pattern\\prototype\\test1\\a.txt"));
        //写对象
        oos.writeObject(citation);
        //释放资源
        oos.close();

        //创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("G:\\OneDrive - hdu.edu.cn\\JAVA\\design_patterns\\src\\main\\java\\com\\tl\\pattern\\prototype\\test1\\a.txt"));
        //读取对象
        Citation citation1 =(Citation) ois.readObject();
        //释放资源
        ois.close();

        citation1.getStudent().setName("李四");
        citation.show();
        citation1.show();
    }
}

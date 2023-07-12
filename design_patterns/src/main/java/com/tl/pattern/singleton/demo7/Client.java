package com.tl.pattern.singleton.demo7;

import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
//        writeObject2File();
        readObjectFromFile();
        readObjectFromFile();
    }

    //从文件读取数据(数据)
    //从文件读取数据（对象）
    public static void readObjectFromFile() throws Exception {
        //1,创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("G:\\OneDrive - hdu.edu.cn\\JAVA\\design_patterns\\src\\main\\java\\com\\tl\\pattern\\singleton\\demo7\\a.txt"));
        //2,读取对象
        Singleton instance = (Singleton) ois.readObject();

        System.out.println(instance);

        //释放资源
        ois.close();
    }
    //向文件中写数据
    public static void writeObject2File() throws IOException {
        //1 获取Singleton对象
        Singleton instance = Singleton.getInstance();
        //2 创建对象输出流
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("G:\\OneDrive - hdu.edu.cn\\JAVA\\design_patterns\\src\\main\\java\\com\\tl\\pattern\\singleton\\demo7\\a.txt"));
        //3 写对象
        os.writeObject(instance);
        //释放资源
        os.close();
    }
}

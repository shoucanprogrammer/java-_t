package hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {

        short  toUnsignedInt = -1234;
        System.out.println(toUnsignedInt);
        //创建哈希表
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:");
            System.out.println("list");
            System.out.println("exit");
            System.out.println("find");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("scanf id");
                    int id = scanner.nextInt();
                    System.out.println("scanf name");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("scanf find id");
                    int id1 = scanner.nextInt();
                    hashTab.findEmpById(id1);
                    break;

                case "exit":
                    scanner.close();
                    System.exit(0);

                default:
                    break;
            }
        }
    }
}
class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }
}
//创建HashTab管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    //构造器
    public HashTab(int size){
        this.size = size;
        //初始化
        empLinkedListArray = new EmpLinkedList[size];
        //初始化每条链表
        for (int i = 0; i< size; i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }

    }
    //添加雇员
    public void add(Emp emp){
        //根据员工id，得到该员工应当添加到那条链表
        int empLinkedListNo = hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }
    //遍历所有链表，遍历hashtab
    public void list(){
        for (int i = 0; i < size; i++){
            empLinkedListArray[i].list(i);
        }
    }
    //根据输入的id，查找雇员
    public void findEmpById(int id){
        //使用散列函数确定到那条链表查找
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null){
            System.out.printf("%d link find id = %d\n",(empLinkedListNo),id);
        }else {
            System.out.println("no find");
        }
    }
    //编写散列函数，使用一个简单取模法
    public int hashFun(int id){
        return id % size;
    }
}
//创建Emp
class EmpLinkedList{
    //头指针，执行第一个emp
    private Emp head;
    //添加雇员到链表
    //假定，当添加雇员时，id时自增长，即id的分配总是从小到大
    //因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助指针，帮助定位到最后
        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }
    //遍历链表的雇员信息
    public void list(int no){
        if (head == null){
            System.out.printf("%d link is empty",no);
            System.out.println();
            return;
        }
        System.out.printf(" %d link is",no);
        Emp curEmp = head;
        while (true){
            System.out.printf("=> id=%d name=%s",curEmp.id,curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
//            System.out.println();
        }
    }

    //根据id查找雇员
    //如果查找到，就返回Emp，如果没找到，就返回null
    public Emp findEmpById(int id){
        //判断链表是否为空
        if (head == null){
            System.out.println("link is empty");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }
            if (curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }


}
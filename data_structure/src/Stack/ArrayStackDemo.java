package Stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试一下 Array
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show");
            System.out.println("exit");
            System.out.println("push");
            System.out.println("pop");
            System.out.println("pease  input choice");
            key = scanner.next();

            switch (key){
                case "show":
                    stack.showlist();
                    break;
                case "push":
                    System.out.println("imput num");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.println("pop  data\n"+res);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                default:
                    break;
            }
        }
        System.out.println("exit precess");
    }
}

class ArrayStack{
    private int maxSize;
    private  int[] stack;
    private int top = -1;

    public  ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    public boolean isFull(){
        return top == maxSize -1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void push(int value){
        //先判断栈是否满
        if (isFull()){
            System.out.println("isFull");
            return;
        }
        top++;
        stack[top] = value;
    }
    public  int pop(){
        //先判断是否为空格
        if (isEmpty()){
            //抛出异常
            throw new RuntimeException("isEmpty no data");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void showlist(){
        if (isEmpty()){
            System.out.println("isEmpty");
            return;
        }
        for (int i = top ;i>=0 ; i--){
            System.out.printf("Stack[%d]\n",i,stack[i]);
        }
    }



}
package queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
//        测试
        ArratQueue arratQueue = new ArratQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show)");
            System.out.println("e(exit)");
            System.out.println("a(add)");
            System.out.println("g(get)");
            System.out.println("h(head)");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arratQueue.showQueue();
                    break;
                case 'a' :
                    System.out.println("scan num");
                    int value = scanner.nextInt();
                    arratQueue.addQuene(value);
                    break;
                case 'g':

                    try {
                        int res = arratQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arratQueue.headQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop =false;
                    break;
                default:
                    break;

            }
        }



    }
}

class  ArratQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    public ArratQueue(int arrMaxsize){
        maxSize =arrMaxsize;
        arr = new int[maxSize];
        front = -1; //指向队列头部 front是队列头的前一个位置
        rear = -1;//指向队列尾 指向队列尾的数据（即就是最后一个数据）
    }
    public boolean isFull(){
        return rear == maxSize-1;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public void addQuene(int n){
        if (isFull()){
            System.out.println("队列已满isFull，不能添加");
            return;
        }
        rear++;
        arr[rear]=n;
    }
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("isEmpty(),不能取数据");
        }
        front++;
        return arr[front];
    }
//    显示队列所以数据据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("isEmpty(),没有数据");
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
//    显示数列头
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空的，没有数据");

        }
        return arr[front+1];
    }



}

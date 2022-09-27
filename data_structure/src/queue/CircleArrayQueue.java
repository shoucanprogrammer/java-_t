package queue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray arratQueue = new CircleArray(3);
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
class CircleArray{
    private int maxSize;
    //        front 含义调整 fornt指向队列第一个元素。也就是说arr[front]
//        front 初始值=0
    private int front;
    //        rear 指向队列的最后一个元素的后一个位置，因为希望空出一位置
//        rear 初始值=0
    private int rear;//队列尾
    private int[] arr;//存放数据 模拟队列

    public CircleArray(int arrMaxSize){
        maxSize =arrMaxSize;
        arr = new int[maxSize];
        front = 0; //指向队列头部 front是队列头的前一个位置
        rear = 0;//指向队列尾 指向队列尾的数据（即就是最后一个数据）
    }
    public boolean isFull(){
        return (rear+1)%maxSize == rear;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public void addQuene(int n){
        if (isFull()){
            System.out.println("队列已满isFull，不能添加");
            return;
        }
        arr[rear]=n;
        rear = (rear + 1) % maxSize;//后移
    }
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("isEmpty(),不能取数据");
        }
        int a =front; //将foront 临时保持 将front后移 将临时保存的变量返回
        front = (front+1) % maxSize;
        return arr[a];
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("isEmpty(),没有数据");
            return;
        }
        //思路 从front开始遍历 ，便利多少个元素
        //求出当前队列有效个数\
        int b =size();
        for (int i=front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i%maxSize]);
        }
        return;
    }
    //求出当前队列有效个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空的，没有数据");

        }
        return arr[front];
    }


}



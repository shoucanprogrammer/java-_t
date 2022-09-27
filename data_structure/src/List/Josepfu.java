package List;

public class Josepfu {
    public static void main(String[] args) {
        //测试一把看看构建环形链表。和遍历是否ok
        CircleSinglinkedList circleSinglinkedList = new CircleSinglinkedList();
        circleSinglinkedList.addBoy(5);
        circleSinglinkedList.showBoy();
        circleSinglinkedList.countBoy(1,2,5);
    }
}
//创建环形单向链表
class CircleSinglinkedList{
    //创建一个fist节点，当前没有编号
    private  Boy first = new Boy(-1);
    public void addBoy(int nums){
        if (nums<1){
            System.out.println("err num");
            return;
        }
//        使用for来创建环形列表
        Boy curBoy = null;
        for (int i=1;i<=nums ;i++) {
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
             //如果是第一个小孩
            if (i==1){
                first = boy;
                first.setNext(first);
                curBoy = first;//让curBoy指向第一个小孩
            }else{
                curBoy.setNext(boy); //
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }
    //遍历当前的环形链表
    public  void showBoy(){
        if (first == null){
            System.out.println("no boy");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.printf("num:%d\n",curBoy.getNo());
            if (curBoy.getNext()==first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    //根据用户输入，计算小孩出圈的顺序
    /*
    startNo 表示从第几个小孩开始数数
    countNum 表示数几下
    nums 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        if (first==null||startNo<1||startNo>nums){
            System.out.printf("param err");
            return;
        }
        //创建辅助指针
        Boy helper = first;
        //需要创建一个辅助指针变量helper，实现应该指向环形链表的最后这个节点
        while (true){
            if (helper.getNext()==first){//说明helper指向最后小孩子节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩包数千，先让first和helper移动到k-1次
        for (int j = 0;j < startNo -1; j++ ){
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时移动m-1次 ，然后出圈
        //这里是一个循环操作，直到圈中只有一个
        while (true){
            if (helper==first){//圈中只有一个节点
                break;
            }
            //让first和helper指针同时移动countNum-1
            for (int j = 0; j < countNum -1; j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //这是first指向的节点，就是要出圈的小孩节点
            System.out.printf("exit :%d",first.getNo());
            //这是将firsr指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("last number :%d\n",first.getNo());
    }


}
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

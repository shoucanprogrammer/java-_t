package List;

import java.util.Stack;

public class Linkedlist {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "tl", "rl1");
        HeroNode hero2 = new HeroNode(2, "tl1", "rl1");
        HeroNode hero3 = new HeroNode(3, "tl2", "rl2");
        HeroNode hero4 = new HeroNode(4, "tl3", "rl3");
        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.ShowList();
        System.out.println();
        HeroNode newhero = new HeroNode(2, "tllll1", "rllll1");
        singleLinkedList.update(newhero);
        singleLinkedList.ShowList();
        System.out.println();
        singleLinkedList.delete(hero1);
        singleLinkedList.ShowList();

        System.out.println();
        singleLinkedList.reversetList(singleLinkedList.getHead());
        singleLinkedList.ShowList();
        singleLinkedList.getHead();
        System.out.println();
        singleLinkedList.reversePrint(singleLinkedList.getHead());
    }

}
//定义SongleLinkedList 管理我们的英雄
class SingleLinkedList{
    //初始化头节点
    private HeroNode head = new HeroNode(0,"","");
    //添加节点到单向链表
    //思路，当不考虑编号的顺序时
    //1找到当前链表阿德最后节点
    //2将最后这个节点的next 指向新节点
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助便利temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    public void delete(HeroNode heroNode){
        HeroNode temp =head;
        boolean flag =false;
        while (true){
            if (temp.next ==null){
                break;
            }
            if (temp.next.no ==heroNode.no){
                flag =true;
                break;
            }
            temp =temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("no find");
        }

    }
    public void addByOrder(HeroNode heroNode){
        //因为头节点,不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head;
        while (true){
            if (temp.next ==null){
                temp.next = heroNode;
                break;
            }
            if (temp.next.no > heroNode.no){
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
            }
            if (temp.next.no == heroNode.no){
                System.out.println("err");
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;

    }
    public void update(HeroNode newHeroNode){
        if (head.next==null){
            System.out.println("empty");
            return;
        }
        //找到需要改变的节点，根据no编号
        HeroNode temp =head.next;
        boolean flag =false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == newHeroNode.no){
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.println("no find"+newHeroNode);
        }

    }
    //显示链表
    public void ShowList(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点,不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            if (temp ==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
    public static void reversetList(HeroNode head){
        //当前链表为空,或者只有一个节点
        if(head.next ==null||head.next.next==null){
            return;
        }
        //定义一个辅助指针,帮我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode revereHead = new HeroNode(0,"","");
        //遍历原来的链表
        //没遍历一次就将其取出，放在新的链表reverseHead的最前端
        while (cur !=null){
            next =cur.next;//暂时保留当前节点的下一个节点，因为后面需要使用
            cur.next = revereHead.next;
            revereHead.next =cur;
            cur =  next;

        }
        head.next =revereHead.next;

    }

    public HeroNode getHead() {
        return head;
    }
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
//定义HeroNode
class HeroNode{
    public int no;
    public String name ;
    public String nickname;
    public HeroNode next;
    public HeroNode(int no,String name,String nicKname){
        this.no = no;
        this.name = name;
        this.nickname = nicKname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

package List;

import java.util.Stack;

public class doubleLinkedListdemo {
    public static void main(String[] args) {
        HeroNode1 hero1 = new HeroNode1(1, "tl", "rl1");
        HeroNode1 hero2 = new HeroNode1(2, "tl1", "rl1");
        HeroNode1 hero3 = new HeroNode1(3, "tl2", "rl2");
        HeroNode1 hero4 = new HeroNode1(4, "tl3", "rl3");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.ShowList();
        System.out.println();
        //修改
        HeroNode1 newHeroNOde1 = new HeroNode1(4,"liulei","liu");
        doubleLinkedList.update(newHeroNOde1);

        doubleLinkedList.ShowList();
        System.out.println();

        doubleLinkedList.delete(new HeroNode1(3,"",""));
        doubleLinkedList.ShowList();
    }

}
class DoubleLinkedList{
    private HeroNode1 head = new HeroNode1(0,"","");
   public HeroNode1 getHead(){
       return head;
   }
    //遍历双向链表
    public void ShowList(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点,不能动，因此我们需要一个辅助变量来遍历
        HeroNode1 temp = head.next;
        while (true){
            if (temp ==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
    public void add(HeroNode1 heroNode){
        //因为head节点不能动，因此我们需要一个辅助便利temp
        HeroNode1 temp = head;
        //遍历链表，找到最后
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //形成双向列表
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    public void update(HeroNode1 newHeroNode){
        if (head.next==null){
            System.out.println("empty");
            return;
        }
        //找到需要改变的节点，根据no编号
        HeroNode1 temp =head.next;
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
    public void delete(HeroNode1 heroNode){
        HeroNode1 temp =head.next;
        boolean flag =false;
        while (true){
            if (temp ==null){
                break;
            }
            if (temp.no ==heroNode.no){
                flag =true;
                break;
            }
            temp =temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if (temp.next!=null)
                temp.next.pre = temp.pre;
        }else {
            System.out.println("no find");
        }

    }

}
class HeroNode1{
    public int no;
    public String name ;
    public String nickname;
    public HeroNode1 next;
    public HeroNode1 pre;
    public HeroNode1(int no,String name,String nicKname){
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
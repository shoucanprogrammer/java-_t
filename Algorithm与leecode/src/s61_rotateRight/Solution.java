package s61_rotateRight;

import org.junit.Test;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    @Test
    public void test(){
        ListNode listNode = rotateRight(new ListNode(1, new ListNode(2)), 4);
        System.out.print(1);
    }

    public ListNode rotateRight(ListNode head, int k){
        //获取长度
        int num =1;
        ListNode list = head;
        if (head == null){
            return null;
        }
        if (k==0){
            return head;
        }

        while (list.next != null){
            list = list.next;
            num++;
        }
        if (num==1){
            return head;
        }
        if (num == k){
            return head;
        }

        //计算步数
        int step = k % num;
        if (step==0){
            return head;
        }
        //计算开始位置
        int start = num - step;
        int i = 1;
        list = head;
        ListNode listNodehead = new ListNode();
        ListNode listNode = new ListNode();
        while (i<=num){
            int fla =0;
            if (i == start+1){
                listNodehead = new ListNode(list.val);
                listNode = listNodehead;
                i++;
                //接尾
                while (i<=num){
                    list =list.next;
                    listNode.next=new ListNode(list.val);
                    listNode = listNode.next;
                    fla =1;
                    i++;
                }
                if (fla==1){
                    break;
                }
            }
            list = list.next;
            i++;

        }
        list = head;
        int num1 = 1;

        //接头
        while (num1 <= start){
            listNode.next=new ListNode(list.val);
            listNode = listNode.next;
            list = list.next;
            num1++;
        }

        return listNodehead;
    }
}


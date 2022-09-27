package recursion;

import java.util.Map;

public class Queue8 {
    //定义一个max表示有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果，比如arr={0,4,7,5,2,6,1,3}
    static int count = 0;
    int[] array = new int[max];
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println();
        System.out.println("sum:"+count);
    }
    //编写一个方法，放置第n个皇后
    private void check(int n){
        if (n == max){
            print();
            return;
        }
        //一次放入皇后，并判断是否冲突
        for(int i = 0 ; i < max ; i++){
            //先把当前的皇后n，放到该行的第1列
            array[n] = i;
            if (judge(n)){//不冲突
                //接着放n+1个皇后，递归
                check(n+1);
            }
            //如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行得 后移的一个位置

        }
    }

    //查看当我们放置地n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    /*
    n 表示地n个皇后
     */
    //写一个方法，可以将皇后拜访的位置输出
    private boolean judge(int n){
        for(int i = 0; i < n; i++){
            //说明
            //1.array[i] == array[n]
            //Math.abs(n-i) == Math.abs(array[n] -array[i]) 判断第n个皇后是否在和第i个皇后在同一斜线
            //n = 1
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] -array[i])){
                return false;
            }
        }
        return true;
    }
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+"");
        }
        System.out.println();
    }

}

package DAC;

public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(3,'A','B','C');
    }
    //汉诺塔的移的动方法
    //使用分治算法
    public static void hanoiTower(int num, char a, char b, char c){
        //如果只有一个盘
        if (num == 1){
            System.out.println("di1"+a+"->"+c);
        }else {
            //如果我们有n >= 2情况，我们总是可以看做是两个盘1.最下边的盘2.上面的盘
            //1.先把最上面的盘A->B，移动过程会使用到c
            hanoiTower(num-1,a,c,b);
            //2.把最下边的盘A->C
            System.out.println("di"+num+""+a+"->"+c);
            //3.把B塔的所有盘从B->C
            hanoiTower(num-1,b,a,c);
        }
    }
}

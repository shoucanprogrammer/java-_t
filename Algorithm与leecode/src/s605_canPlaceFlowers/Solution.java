package s605_canPlaceFlowers;

public class Solution {
    /**
     * 贪心
     * 能种花的地方
     *  当前位置没有花
     *  前面要么没有花, 要么是边界
     *  后面要么没有花, 要么是边界
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == length-1 || flowerbed[i+1] == 0)){
                n--;
                //把花种上
                flowerbed[i] = 1;
            }
            if (n <= 0){
                return true;
            }
        }
        return false;
    }
}

package s4_longestCommonPrefix;

import org.testng.annotations.Test;

public class Solution1 {
    @Test
    public void test2(){
        String s = longestCommonPrefix(new String[]{"flow","flowe","flowqq"});
        System.out.println();
    }
    public String longestCommonPrefix(String[] strs){
        int mid = 0;
        int star = 0;
        int end;
        if (strs == null || strs.length == 0){
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String s : strs){
            minLength = Math.min(minLength,s.length());
        }
        end = minLength;
        if (minLength == 0)
            return "";
        while (star < end){
            mid = (star+end+1)/2;
            if (isCommon(strs,star,mid)){
                star = mid;
            }else {
                end = (mid - 1);
            }
        }
     return strs[0].substring(0,end);
    }
    public boolean isCommon(String[] strs ,int star, int end){
        for(String str : strs){
            if (str.substring(star,end).equals(strs[0].substring(star,end))){

            }else {
                return false;
            }
        }
        return true;
    }
}

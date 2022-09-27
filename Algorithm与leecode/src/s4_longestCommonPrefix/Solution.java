package s4_longestCommonPrefix;


import org.junit.Test;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
    @Test
    public void test(){
        String s = longestCommonPrefix1(new String[]{"flower", "flower", "flower", "flower"});
        System.out.println();
    }
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length==0){
            return "";
        }else {
            return longestCommonPrefix(strs,0,strs.length-1);
        }
    }
    public String longestCommonPrefix(String[] strs, int start, int end){
        if (start == end){
            return strs[start];
        }
        int mid = (end - start) / 2 + start;
        String left = longestCommonPrefix(strs,start,mid);
        String right = longestCommonPrefix(strs,mid + 1,end);
        return commonPrefix(left,right);
    }
    public String commonPrefix(String left,String right){
        int len = Math.min(left.length(),right.length());
        int i;
        for (i = 0; i < len; i++){
            if (left.charAt(i) != right.charAt(i)){
                break;
            }
        }
        String substring = left.substring(0, i );
        return left.substring(0,i);
    }



    

}


package s97_isInterleave;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        isInterleave("aabcc","dbbca","aadbbcbcac");
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int o = s3.length();
        if (o!=m+n){
            return false;
        }else {
            boolean left = left(s1, s2, s3);
            if (left == true){
                return true;
            }
            boolean right = right(s2, s1, s3);
            if (right == true){
                return true;
            }

        }
        return false;
    }
    public boolean left(String s1, String s2, String s3){
        int m = s1.length();
        int n = s2.length();
        int o = s3.length();
        int n1= 0;
        int m1 = 0;
        int o1 = 0;
        int fla1 = 0;
        int fla2 = 0;
        for (int i = 0; o1  < o; i++){
            while (m1<m&&o1<o&&s3.charAt(o1)==s1.charAt(m1)){
                o1++;
                m1++;
                fla1 = 1;
                fla2 = 0;
            }
            if (fla1==0)
                return false;
            while (n1<n&&o1<o&&s3.charAt(o1)==s2.charAt(n1)){
                o1++;
                n1++;
                fla1 = 0;
                fla2 = 1;
            }
            if (fla1==1&&fla2==0&&o1!=o)
                return false;
            if (fla2==0&&fla1==0)
                return false;
        }
        if (o1!=o)
            return false;
        return true;
    }

    public boolean right(String s1, String s2, String s3){
        int m = s1.length();
        int n = s2.length();
        int o = s3.length();
        int n1= 0;
        int m1 = 0;
        int o1 = 0;
        int fla1 = 0;
        int fla2 = 0;
        for (int i = 0; o1  < o; i++){
            while (m1<m&&o1<o&&s3.charAt(o1)==s1.charAt(m1)){
                o1++;
                m1++;
                fla1 = 1;
                fla2 = 0;
            }
            if (fla1==0)
                return false;
            while (n1<n&&o1<o&&s3.charAt(o1)==s2.charAt(n1)){
                o1++;
                n1++;
                fla1 = 0;
                fla2 = 1;
            }
            if (fla1==1&&fla2==0&&o1!=o)
                return false;
            if (fla2==0&&fla1==0)
                return false;
        }
        if (o1!=o)
            return false;
        return true;
    }
}

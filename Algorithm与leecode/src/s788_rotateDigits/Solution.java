package s788_rotateDigits;

public class Solution {
    public int rotatedDigits(int n ){
        int ans = 0;
        for (int i = 1; i <= n; i++){
            String s = String.valueOf(i);
            boolean valid = true; boolean diff = false;
            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) == '3'||s.charAt(j) == '4'||s.charAt(j) == '7'){
                    valid = false;
                    break;
                }
                if (s.charAt(j) == '2'||s.charAt(j) == '5'||s.charAt(j) == '6'||s.charAt(j) == '9'){
                    diff = true;
                }
            }
            if (valid && diff){
                ans++;
            }
        }
        return ans;
    }
}

package s171_titleToNumber;

public class Solution {
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int n = chars.length;
        int sum = 0;
        for (int i = 0; i < chars.length; i++){
            sum = sum * 26 + chars[i] - 'A'+1;
        }
        return sum;
    }
}

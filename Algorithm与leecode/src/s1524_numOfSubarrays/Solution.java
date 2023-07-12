package s1524_numOfSubarrays;

public class Solution {
    public int numOfSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        int[] count = new int[2];
        count[0] = 1;
        long ans = 0;
        for (int i = 0; i < n; i++){
            sum += arr[i];
            if (sum % 2 == 1){
                ans += count[0];
                count[1]++;
            }else {
                ans += count[1];
                count[0]++;
            }
        }
        return (int) (ans%(Math.pow(10,9)+7));
    }
}

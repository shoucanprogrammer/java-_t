package s769_maxChunksToSorted;

import java.util.Stack;

//public class Solution {
//    public int maxChunksToSorted(int[] arr) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(arr[0]);
//        int max = arr[0];
//        int ans = 1;
//        for (int i = 1; i < arr.length; i++){
//            if (arr[i] > max &&stack.size()>=max){
////                stack.clear();
//                ans++;
//            }
//            stack.push(arr[i]);
//            if (arr[i] > max){
//                max = arr[i];
//            }
//        }
//        return ans;
//    }
//}
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        // Stack<Integer> stack = new Stack<>();

        int max = 0;
        int count = 0;
        int ans = 1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max && count>max){
                // stack.clear();
                ans++;
            }
            // stack.push(arr[i]);
            count++;
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return ans;
    }
}
package s2657_findThePrefixCommonArray;

import java.util.Collections;
import java.util.HashSet;

public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        int[] C = new int[A.length];
        if (A[0] == B[0]){
            C[0] = 1;
        }
        setA.add(A[0]);
        setB.add(B[0]);
        for (int i = 1; i < A.length; i++){
            setA.add(A[i]);
            setB.add(B[i]);
            C[i] = C[i-1];
            if (setA.contains(B[i])){
                C[i] ++;
            }
            if (A[i] == B[i]){
                continue;
            }
            if (setB.contains(A[i])){
                C[i] ++;
            }
        }
        return C;
    }
}

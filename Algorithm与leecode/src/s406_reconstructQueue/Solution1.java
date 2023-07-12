package s406_reconstructQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] = o2[1];
                }
                return o2[1] - o1[1];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] peopleOne : people){
            ans.add(peopleOne[0],peopleOne);
        }
        for (int i = 0; i < people.length; i++){
            people[i] = ans.get(i);
        }
        return people;
    }
}

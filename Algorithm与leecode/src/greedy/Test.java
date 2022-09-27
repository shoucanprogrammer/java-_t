package greedy;

import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet hashSet1 = new HashSet<String>();
        HashSet hashSet2 = new HashSet<String>();
        hashSet1.add("1");
        hashSet1.add("2");
        hashSet1.add("100");

        hashSet2.add("1");
        hashSet2.add("2");
        hashSet2.add("200");
        hashSet1.retainAll(hashSet2);
        System.out.println("hashSet1=" + hashSet1);

    }
}

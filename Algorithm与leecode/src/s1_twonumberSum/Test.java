package s1_twonumberSum;

public class Test {
    public static void main(String[] args) {
        int[] twoSunm = new int[]{1,2,3,4};
        int target = 10;
        Solution_1 solution_1= new Solution_1();
        System.out.println(twoSunm);
        int[] i = solution_1.twoSum(twoSunm,target);
        System.out.println(solution_1.twoSum(twoSunm,target));
        System.out.println(i[0]);
//        System.out.println(i[1]);
        


    }
}

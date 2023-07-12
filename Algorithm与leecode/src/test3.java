public class test3 {
    public static void main(String[] args) {
        int test = test();
        System.out.println(test);
    }
    public static int test(){
        int i=0;
        try {
            i = 5 / 0;
        }catch (Exception e){
            return 2*3;
        }finally {
            return 3;
        }
    }
}

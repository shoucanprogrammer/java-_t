package s2_isPalindrome;

public class isPalindrome {
    public boolean isPalindrome(int x){
        String number = String.valueOf(x);
        char[] stringArr= number.toCharArray();
        System.out.println(number);
        for(int i=0;i<1;i++){
            for (int j=stringArr.length-1; i<=j;j--,i++){
                if (stringArr[i]!=stringArr[j]){
                    return false;
                }
            }
            break;
        }

        return true;
    }

}

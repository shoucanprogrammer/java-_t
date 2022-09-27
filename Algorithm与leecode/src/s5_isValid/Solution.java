package s5_isValid;

public class Solution {
    public boolean isValid(String s) {
        if (s.length()%2!=0)
            return false;
        else {
            int counter =0;
            int a=s.length()/2;
            while (counter<=a){
                s=s.replace("()","").replace("[]","").replace("{}","");
                counter++;
            }
            if (s.equals("")){
                return true;
            }

        }
    return false;
    }
}


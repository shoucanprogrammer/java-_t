package s38_countAndSay;

import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    @Test
    public void test(){
        String s = countAndSay(4);
    }
    public String countAndSay(int n){
        int count = 1;
        if (n==1){
            return "1";
        }
        ArrayList<String> list = new ArrayList();
        list.add("1");
        while (count < n){
            //size()在变化
            //i用来计数并不是用来遍历
            String first = null;//记录第一次出现的字符
            String remove = null;
            list.add("s");
          for (int i = 1; ;){
              if (first != null){
                  if (!(list.get(0).equals(first))){
                      list.add(String.valueOf(i));
                      list.add(first);
                      i = 1;
                      first = list.get(0);
                  }else {
                      i++;
                  }
              }else if (first == null){
                  first = list.get(0);
              }
              remove = list.remove(0);
              if ("s".equals(remove))
                  break;;
          }
          count++;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(String str:list){
            stringBuffer.append(str);
        }
        return String.valueOf(stringBuffer);
    }
}

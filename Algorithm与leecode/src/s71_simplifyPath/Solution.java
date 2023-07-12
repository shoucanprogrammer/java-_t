package s71_simplifyPath;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    @Test
    public void test(){
        String s = simplifyPath("/a/./b/..//../c/");
        System.out.println(1);
    }
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name:names){
            if (("..").equals(name)){
                //如果等于..则删除上一级路径
                stack.pollLast();
            }else if (name.length() > 0 && !".".equals(name)){
                //排空和‘.’
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()){
            ans.append('/');
        }else {
            while (!stack.isEmpty()){
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }
}

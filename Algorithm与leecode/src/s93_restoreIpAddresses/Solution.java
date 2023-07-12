package s93_restoreIpAddresses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        restoreIpAddresses("25525511135");
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList();
        List<String> temp=new ArrayList();
        backTracking(s,0,ans,temp);
        return ans;
    }

    public void backTracking(String s,int begin,List<String> ans,List<String> temp){
        if(temp.size()==4){
            if(begin==s.length()){
                ans.add(String.join(".",temp));
            }
            return;
        }
        for(int i=begin;i<begin+3&&i<s.length();++i){
            String sub=s.substring(begin,i+1);
            if(!isRange(sub)){
                continue;
            }
            temp.add(sub);
            backTracking(s,i+1,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
    public boolean isRange(String sub){
        if(sub.length()!=1&&sub.charAt(0)=='0'){
            return false;
        }
        return Integer.parseInt(sub)<=255?true:false;
    }
}

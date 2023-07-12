package s89_grayCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class solution {
    @Test
    public void test(){
        grayCode(3);
    }
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i);
        }
        return ret;
    }

}

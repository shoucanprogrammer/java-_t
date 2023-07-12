package com.tl.dianping;

import com.tl.dianping.dto.LoginFormDTO;
import com.tl.dianping.dto.Result;
import com.tl.dianping.entity.User;
import com.tl.dianping.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

@SpringBootTest
public class loginTest {
    @Resource
    private UserServiceImpl userService;
    @Test
    public void test() throws IOException {
        for (long i = 17364520645L; i < 17364521645L; i++){
            Result result = userService.sendCode(String.valueOf(i), null);
            String code = (String) result.getData();
            LoginFormDTO loginForm = new LoginFormDTO();
            loginForm.setPhone(String.valueOf(i));
            loginForm.setCode(code);
            Result result1 = userService.login(loginForm, null);
            String token = (String) result1.getData();
            String path = "G:\\OneDrive - hdu.edu.cn\\JAVA\\dianping\\tokens.txt";

            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(path,true)));
            out.write(token+"\r\n");
            out.close();
        }

    }
}

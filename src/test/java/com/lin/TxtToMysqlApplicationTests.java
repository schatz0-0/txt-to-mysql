package com.lin;

import com.lin.service.changeTxt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TxtToMysqlApplicationTests {
    @Autowired
    private changeTxt changeTxt;

    @Test
    void contextLoads() {

        changeTxt.run();

    }

}

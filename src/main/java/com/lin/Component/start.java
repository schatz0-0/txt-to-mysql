package com.lin.Component;

import com.lin.service.changeTxt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 此方式废弃
 */
//@Slf4j
//@Component
public class start implements ApplicationRunner {
    @Autowired
    private com.lin.service.changeTxt changeTxt;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        changeTxt.run();
    }
}
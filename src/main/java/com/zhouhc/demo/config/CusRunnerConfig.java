package com.zhouhc.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CusRunnerConfig implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("调用CommandLineRunner的run()");
    }
}

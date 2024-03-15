package com.demo.springshelldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.shell.command.annotation.CommandScan;

@CommandScan
@SpringBootApplication
@EnableFeignClients
public class SpringShellDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShellDemoApplication.class, args);
    }

}

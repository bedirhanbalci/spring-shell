package com.demo.springshelldemo.config;

import com.demo.springshelldemo.exception.ExceptionHandler;
import com.demo.springshelldemo.util.ShellReader;
import org.jline.reader.LineReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class ApplicationConfig {

    @Bean
    ExceptionHandler exceptionHandler() {
        return new ExceptionHandler();
    }

    @Bean
    public ShellReader shellReader(@Lazy LineReader lineReader) {
        return new ShellReader(lineReader);
    }

}

package com.rjgf.hadoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @email: xuliandream@gmail.com
 * @author: xula
 * @date: 2020/8/28
 * @time: 11:14
 */
@EnableTransactionManagement
@SpringBootApplication
public class RjgfHadoopApplication {

    public static void main(String[] args) {
        SpringApplication.run(RjgfHadoopApplication.class, args);
    }
}

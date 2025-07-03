package org.baron.chuck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "org.baron.chuck.client")
public class ChuckApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChuckApplication.class, args);
    }

}

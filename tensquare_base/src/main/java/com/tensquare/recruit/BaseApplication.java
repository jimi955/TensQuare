package com.tensquare.recruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import utils.IdWorker;

@SpringBootApplication
@EnableEurekaClient
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

    /**
     * 将id生成器放到容器中 bean的id可以指定 不写默认是方法名idWorker
     * @return
     */
    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}

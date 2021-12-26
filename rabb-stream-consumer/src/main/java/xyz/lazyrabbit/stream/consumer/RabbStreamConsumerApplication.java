package xyz.lazyrabbit.stream.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Date;
import java.util.function.Consumer;

@SpringBootApplication
public class RabbStreamConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbStreamConsumerApplication.class, args);
    }

    @Bean
    public Consumer<Date> sink1() {
        return System.out::println;
    }

    @Bean
    public Consumer<String> sink2() {
        return message -> {
            System.out.println("sink2 receive message：" + message);
        };
    }
}

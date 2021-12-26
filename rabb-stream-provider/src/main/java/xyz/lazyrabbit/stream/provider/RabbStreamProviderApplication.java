package xyz.lazyrabbit.stream.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.function.Supplier;

@SpringBootApplication

public class RabbStreamProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbStreamProviderApplication.class, args);
    }

//    @Bean
//    public Supplier<Date> source1() {
//        return () -> new Date();
//    }
}

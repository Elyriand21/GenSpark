package org.genspark;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public Student student(){
        return new Student(356812,"Jacob Smith", (List<Phone>) phone(),address());
    }
    @Bean
    public Address address(){
        return new Address("Asheville","NC","USA","28806");
    }
    @Bean
    public Phone phone(){
        return new Phone("8287563456");
    }
}

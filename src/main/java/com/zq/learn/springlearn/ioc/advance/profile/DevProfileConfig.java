package com.zq.learn.springlearn.ioc.advance.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevProfileConfig {

    @Bean
    public Application application(){
        return new Application("dev");
    }
}

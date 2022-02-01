package ru.netology.conditionalspring.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.conditionalspring.model.DevProfile;
import ru.netology.conditionalspring.model.ProductionProfile;
import ru.netology.conditionalspring.model.SystemProfile;

@Configuration
public class Config {

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev = true", havingValue = "true", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev = false", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}

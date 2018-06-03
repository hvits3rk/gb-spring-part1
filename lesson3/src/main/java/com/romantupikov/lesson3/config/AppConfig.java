package com.romantupikov.lesson3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.romantupikov.lesson3.service")
public class AppConfig {
}

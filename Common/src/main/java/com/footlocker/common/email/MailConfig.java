package com.footlocker.common.email;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(locations = "classpath:application.properties", ignoreUnknownFields = false, prefix = "spring.mail")
public class MailConfig {

    @NotBlank
    private String host;
    
    public void setHost(String host) {
    	this.host = host;
    }
    
    public String getHost(String host) {
    	return host;
    }

    @Bean
    public JavaMailSender javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        return javaMailSender;
    }
}
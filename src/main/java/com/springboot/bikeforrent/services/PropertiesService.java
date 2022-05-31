package com.springboot.bikeforrent.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertiesService {

    @Value("${env}")
    private String env;

    public String getUrl() {
        return String.format("www.%s.savings", env);
    }
}

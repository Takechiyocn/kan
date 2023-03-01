package org.moku.consumer.controller;

import org.moku.consumer.configinfo.ConfigInfoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigController
 * @Description
 * @Author moku
 * @Date 2023/3/1 12:00
 * @Version 1.0
 */
@RestController
public class ConfigController {
    @Autowired
    private ConfigInfoProperties configInfoProperties;
    @Value("${author.name}")
    private String config;

    @GetMapping("/test/config")
    public String getConfig() {
        return config + configInfoProperties.getConfig();
    }
}

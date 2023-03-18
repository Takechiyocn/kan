package org.moku.consumer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.moku.consumer.configuration.AuthorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
public class ConfigController {
    @Autowired
    private AuthorProperties authorProperties;
//    @Value("${author.name}")
//    private String config;
    @Value("${author.name}")
    private String name;

    @GetMapping("/getconfig")
    public String getConfig() throws JsonProcessingException {
        System.out.println(name);
        return new ObjectMapper().writeValueAsString(authorProperties);
    }
}

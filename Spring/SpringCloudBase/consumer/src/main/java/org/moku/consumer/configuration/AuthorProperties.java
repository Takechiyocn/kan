package org.moku.consumer.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName AuthorProperties
 * @Description
 * @Author moku
 * @Date 2023/3/1 15:24
 * @Version 1.0
 */
@Component
@ConfigurationProperties(value = "author")
@Data
public class AuthorProperties {
    private String name;
    private String pwd;
}

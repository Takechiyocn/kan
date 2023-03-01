package org.moku.consumer.configinfo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ConfigInfoProperties
 * @Description
 * @Author moku
 * @Date 2023/3/1 14:50
 * @Version 1.0
 */

@Component
@ConfigurationProperties(prefix = "cn.springcloud.book")
public class ConfigInfoProperties {
    private String config;
    public String getConfig() {
        return config;
    }
    public void setConfig(String config) {
        this.config = config;
    }
}
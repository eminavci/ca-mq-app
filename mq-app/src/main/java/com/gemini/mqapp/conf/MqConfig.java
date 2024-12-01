package com.gemini.mqapp.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "ibm.mq")
public class MqConfig {

    private String host;
    private Integer port;
    private String queueManager;
    private String channel;
    private String queueName;


}

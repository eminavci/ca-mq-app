package com.gemini.mqapp.conf;

import com.gemini.mqapp.mq.MqListener;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
@Profile("test-message")
public class DefaultMqMessages implements ApplicationRunner {

    private final MqListener mq;
    private static Logger logger = LogManager.getLogger(DefaultMqMessages.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Profile: test-message, generating 10 custom MQ messages!");
        IntStream.range(0, 10).forEach(i -> {
            mq.sendMessage("My custom Message " + i);
        });
    }
}

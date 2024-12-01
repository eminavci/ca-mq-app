package com.gemini.mqapp.mq;

import com.gemini.mqapp.model.QmMessage;
import com.gemini.mqapp.service.MqMessageService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jms.*;

@Configuration
@RequiredArgsConstructor
@EnableScheduling
public class MqListener {

    private final QueueConnection queueConnection;
    private final QueueSession session;
    private final MessageConsumer consumer;
    private final MessageProducer producer;
    private final MqMessageService mqMessageService;
    private static final Logger logger = LogManager.getLogger(MqListener.class);

    @PostConstruct
    private void postConst() throws JMSException {
        queueConnection.start();
    }

    @Scheduled(fixedDelay = 5000)
    private void listenMq() {
        try {
            Message message;
            while ((message = consumer.receive(100)) != null) {
                if (message instanceof TextMessage) {
                    TextMessage msg = (TextMessage) message;
                    QmMessage save = mqMessageService.persist(msg.getJMSMessageID(), msg.getJMSTimestamp(), msg.getText());
                    logger.info("RECEIVED and persisted : " + save);
                } else {
                    logger.info("Received non-ObjectMessage: " + message);
                }
            }
        } catch (JMSException e) {
            logger.error("IBM MQ listener Error: ", e);
        }
    }

    public void sendMessage(String messageText) {

        try {
            producer.send(session.createTextMessage(messageText));
            logger.info("Message Send to Queue: " + messageText);
        } catch (JMSException e) {
            logger.error("IBM MQ Sender Error: ", e);
        }
    }

    @PreDestroy
    private void closeCons() throws JMSException {
        if (this.session != null) {
            this.session.close();
        }
        if (this.queueConnection != null) {
            this.queueConnection.close();
        }
    }
}

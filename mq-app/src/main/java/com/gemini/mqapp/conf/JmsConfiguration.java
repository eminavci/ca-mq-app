package com.gemini.mqapp.conf;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.*;

@Configuration
@RequiredArgsConstructor
public class JmsConfiguration {

    private final MqConfig mqConfig;

    @Bean
    public QueueConnectionFactory createConnectionFactory() throws JMSException {
        MQQueueConnectionFactory factory = new MQQueueConnectionFactory();
        factory.setHostName(mqConfig.getHost());
        factory.setPort(mqConfig.getPort());
        factory.setQueueManager(mqConfig.getQueueManager());
        factory.setChannel(mqConfig.getChannel());
        factory.setTransportType(WMQConstants.WMQ_CM_CLIENT); // Client mode
        return factory;
    }

    @Bean
    public Queue getQueue(QueueSession session) throws JMSException {
        return session.createQueue(mqConfig.getQueueName());
    }

    @Bean
    public QueueConnection getQueueConnection(QueueConnectionFactory queueConnectionFactory) throws JMSException {
        return queueConnectionFactory.createQueueConnection();
    }

    @Bean
    public QueueSession getQueueSession(QueueConnection queueConnection) throws JMSException {
        return queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    @Bean
    public MessageConsumer getMessageConsumer(QueueSession queueSession) throws JMSException {
        return queueSession.createConsumer(getQueue(queueSession));
    }

    @Bean
    public MessageProducer getMessageProducer(QueueSession queueSession) throws JMSException {
        return queueSession.createProducer(getQueue(queueSession));
    }
}

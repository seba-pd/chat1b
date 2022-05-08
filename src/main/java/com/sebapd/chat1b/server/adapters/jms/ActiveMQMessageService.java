package com.sebapd.chat1b.server.adapters.jms;

import com.sebapd.chat1b.server.domain.Message;
import com.sebapd.chat1b.server.ports.JMSMessageService;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQMessageService implements JMSMessageService {

    private static final String BROKER_URL = "tcp://localhost:61616";

    @Override
    public void toBroker(Message message) {
        ConnectionFactory factory = new ActiveMQConnectionFactory(BROKER_URL);
        try (Connection con = factory.createConnection()) {

            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic(message.getChannelName());

            MessageProducer producer = session.createProducer(topic);
            TextMessage messageToSend = session.createTextMessage(message.messageToJsonString());
            producer.send(messageToSend);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

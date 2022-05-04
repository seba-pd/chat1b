package com.sebapd.chat1b.chat.adapters.jms;

import com.sebapd.chat1b.chat.domain.Message;
import com.sebapd.chat1b.chat.ports.JMSMessageService;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQMessageService implements JMSMessageService {

    @Override
    public void toBroker(Message message, String channelName) {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try (Connection con = factory.createConnection()) {

            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic(channelName);

            MessageProducer producer = session.createProducer(topic);
            TextMessage messageToSend = session.createTextMessage(message.messageToString());
            producer.send(messageToSend);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

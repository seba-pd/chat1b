package com.sebapd.chat1b.client;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ChatClient {

    public static void main(String[] args) {
        listenChannel();
    }

    private static void listenChannel() {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection con = null;

        try {
            con = factory.createConnection();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("test2");

            MessageConsumer consumer = session.createConsumer(topic);

            consumer.setMessageListener(msg -> {
                try {
                    if (!(msg instanceof TextMessage tm))
                        throw new RuntimeException("no text message");
                    System.out.println(tm.getText());
                } catch (JMSException e) {
                    System.err.println("Error reading message");
                }
            });
            con.start();
        } catch (JMSException e1) {
            e1.printStackTrace();
        } finally {
            try {
                assert con != null;
                con.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}

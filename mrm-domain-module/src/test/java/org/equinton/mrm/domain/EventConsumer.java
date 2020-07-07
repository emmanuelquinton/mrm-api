package org.equinton.mrm.domain;

import org.apache.qpid.jms.JmsConnectionFactory;
import org.apache.qpid.jms.message.JmsMessage;

import javax.jms.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class EventConsumer {

    public void run() {
        ConnectionFactory connectionFactory = new JmsConnectionFactory("admin", "admin", "amqp://localhost:5672");

        JMSContext contextConsumer = connectionFactory.createContext();
        Topic topicConsumer = contextConsumer.createTopic("room/creation");
        JMSConsumer consumer = contextConsumer.createConsumer(topicConsumer);




        //System.out.println(actualMessage);

        AsyncClient asyncClient = new AsyncClient();

        consumer.setMessageListener(asyncClient);




    }

    public static void main(String[] args) {
        new EventConsumer().run();
    }


    public class AsyncClient implements MessageListener {

        public void onMessage(Message message) {

            try {

                System.out.println(">>>>>>> get body");

                String body =  getBody(message);
                System.out.println(">>>>>>> body = " + body);
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }

        private String getBody(Message message) throws JMSException {
            String payload = null;
            if (message instanceof BytesMessage) {
                payload =new String(message.getBody(byte[].class));
            }
            else if (message instanceof TextMessage) {
                payload = message.getBody(String.class);
            }
            return payload;
        }


    }
}
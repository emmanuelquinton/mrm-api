package org.equinton.mrm.domain;

import org.apache.qpid.jms.JmsConnectionFactory;

import javax.jms.*;

public class EventPublisher {

    public void run() {
        ConnectionFactory connectionFactory = new JmsConnectionFactory("admin", "admin", "amqp://localhost:5672");


        JMSContext context = connectionFactory.createContext();
        Topic topic = context.createTopic("pub/sub/plus");


        //
        TextMessage message = context.createTextMessage("Hello Emmanuel");
        JMSProducer producer = context.createProducer().setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        producer.send(topic, message);




    }

    public static void main(String[] args) {
        new EventPublisher().run();

    }
}

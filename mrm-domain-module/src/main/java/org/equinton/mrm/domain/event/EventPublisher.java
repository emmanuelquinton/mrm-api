package org.equinton.mrm.domain.event;

import org.apache.qpid.jms.JmsConnectionFactory;
import org.equinton.mrm.domain.model.Reservation;

import javax.jms.*;

public class EventPublisher {


    public void publishReservation(Reservation reservation) {
        ConnectionFactory connectionFactory = new JmsConnectionFactory("admin", "admin", "amqp://localhost:5672");


        JMSContext context = connectionFactory.createContext();
            Topic topic = context.createTopic("mrm/room/creation");


        //
       ObjectMessage message = context.createObjectMessage(reservation);
        JMSProducer producer = context.createProducer().setDeliveryMode(DeliveryMode.PERSISTENT);
        producer.send(topic, message);
    }
}

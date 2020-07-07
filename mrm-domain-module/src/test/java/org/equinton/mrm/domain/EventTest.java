package org.equinton.mrm.domain;

import org.apache.qpid.jms.JmsConnectionFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class EventTest {





    void  should_publish_subscribe_event() {

        try {

            Hashtable<Object, Object> env = new Hashtable<Object, Object>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.qpid.jms.jndi.JmsInitialContextFactory");
            env.put("connectionfactory.myFactoryLookup", "amqp://localhost:5672");
            env.put("queue.myQueueLookup", "queueA");
            env.put("topic.myTopicLookup", "topicA");


            javax.naming.Context context = new javax.naming.InitialContext(env);

            ConnectionFactory factory = (ConnectionFactory) context.lookup("myFactoryLookup");
            Destination queue = (Destination) context.lookup("myQueueLookup");


            Connection connection = factory.createConnection("default", "default");
            connection.setExceptionListener(new MyExceptionListener());
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //Create a temporary queue and consumer to receive responses, and a producer to send requests.
            TemporaryQueue responseQueue = session.createTemporaryQueue();
            MessageConsumer messageConsumer = session.createConsumer(responseQueue);
            MessageProducer messageProducer = session.createProducer(queue);

            //Send some requests and receive the responses.
            String[] requests = new String[]{"Twas brillig, and the slithy toves",
                    "Did gire and gymble in the wabe.",
                    "All mimsy were the borogroves,",
                    "And the mome raths outgrabe."};

            for (String request : requests) {
                TextMessage requestMessage = session.createTextMessage(request);
                requestMessage.setJMSReplyTo(responseQueue);

                messageProducer.send(requestMessage, DeliveryMode.NON_PERSISTENT, Message.DEFAULT_PRIORITY, Message.DEFAULT_TIME_TO_LIVE);

                TextMessage responseMessage = (TextMessage) messageConsumer.receive(2000);
                if (responseMessage != null) {
                    System.out.println("[CLIENT] " + request + " ---> " + responseMessage.getText());
                } else {
                    System.out.println("[CLIENT] Response for '" + request + "' was not received within the timeout, exiting.");
                    break;
                }
            }

            connection.close();
        } catch (
                Exception exp) {
            System.out.println("[CLIENT] Caught exception, exiting.");
            exp.printStackTrace(System.out);
            System.exit(1);
        }
    }

    private static class MyExceptionListener implements ExceptionListener {
        @Override
        public void onException(JMSException exception) {
            System.out.println("[CLIENT] Connection ExceptionListener fired, exiting.");
            exception.printStackTrace(System.out);
            System.exit(1);
        }
    }







    void should_publish_event() {
        //
        ConnectionFactory connectionFactory = new JmsConnectionFactory("admin", "admin", "amqp://localhost:5672");


        JMSContext context = connectionFactory.createContext();
        Topic roomCreationTopic = context.createTopic("room/creation");

        //
        TextMessage message = context.createTextMessage("" +
                "Hello Emmanuel");
        JMSProducer producer = context.createProducer().setDeliveryMode(DeliveryMode.PERSISTENT);
        producer.send(roomCreationTopic, message);

    }

}






package com.listener;

import javax.jms.JMSException;
import javax.jms.TextMessage;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class FirstJmsConsumer {

	


	    private static Logger LOG = LoggerFactory.getLogger(FirstJmsConsumer.class);

	    @JmsListener(containerFactory = "defaultJmsListenerContainerFactory", destination = "jms/test/TestQueue", selector = "selector = 'first'")
	    public void consume(TextMessage message) throws JMSException {
	        LOG.info("in consumer first");

	        LOG.info("Consumed by first : " + message.getText());

	    }


}

package com.example.jmsreader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSListener {

 static Map<String, String> sMap = new HashMap<String, String>();
    @JmsListener(containerFactory = "myFactory", destination = "${jms.destinationName}")
    public void receiveMessage(String msj) {
    	sMap.put(msj, msj);
        System.out.println(" msj:::::: " +msj);
    }
}
package com.example.jmsreader;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest")

public class ConsumeColaController  {
    private static Logger log = LoggerFactory.getLogger(ConsumeColaController.class);

	@Autowired 
	private JmsTemplate  jmsTemplate;
	@Autowired 
	private MessageSender messageSender;
    @RequestMapping(method = RequestMethod.POST, value ="/send/{message}")
	@ResponseBody
    public void sendMessage(@PathVariable String message) {
        try {
           // jmsTemplate.convertAndSend("jms/test/TestQueue",message);
        	messageSender.send("jms/test/TestQueue",message);


        } catch (Exception e) {
log.error(e.getMessage());

        }
 
 
    }


	/**
	 * @param user
	 * @return
	 * @throws JMSException
	 * @throws NamingException
	 */
	/**
	 * @param user
	 * @return
	 * @throws JMSException
	 * @throws NamingException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/jms/consumeQueue", produces = "application/json")
	@ResponseBody
	public Map<String, String> consumeServiceRest( @RequestParam(name = "user") String user) throws JMSException, NamingException {
		System.out.println("start leyendo cola " + user);

		Destination dest = null;
		HashMap<String, String> map = new HashMap<>();
	    map.put("key", "value");
	    map.put("foo", "bar");
	    map.put("aa", "bb");

		System.out.println("sMap " + JMSListener.sMap);
	    return map;
	
	}

	
	 

}

package cl.fonasa.push.controller;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.fonasa.push.consume.JMSListener;
import cl.fonasa.push.jmssender.MessageSender;

@Controller
@RequestMapping("/rest")

public class ConsumeColaController {
	private static Logger log = LoggerFactory.getLogger(ConsumeColaController.class);

	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private MessageSender messageSender;
    @Value("${jms.destinationName}")
    private String destinationName;
	@RequestMapping(method = RequestMethod.POST, value = "/send/{message}")
	@ResponseBody
	public void sendMessage(@PathVariable String message) {
		try {
			// jmsTemplate.convertAndSend("jms/test/TestQueue",message);
			messageSender.send(destinationName, message);

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
	@RequestMapping(method = RequestMethod.GET, value = "jms/consumeQueue", produces = "application/json")
	@ResponseBody
	public String consumeServiceRest(@RequestParam(name = "user") String user) throws JMSException, NamingException {
		log.debug("start leyendo cola " + user);
		String resp = "nook";
		Destination dest = null;
		log.debug("user:: " + JMSListener.sMap);
		if (user.equals(JMSListener.sMap.get(user))) {
			JMSListener.sMap.remove(user);
			resp = "ok";
		}
		log.debug("sMap " + JMSListener.sMap);
		return resp;

	}

}

package cl.fonasa.push.consume;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSListener {
	private static Logger LOG = LoggerFactory.getLogger(JMSListener.class);
	public static Map<String, String> sMap = new HashMap<String, String>();

	@JmsListener(containerFactory = "factoryJms", destination = "${jms.destinationName}")
	public void receiveMessage(String msj) {
		sMap.put(msj, msj);
		LOG.info(" msj:::::: " + msj);
	}
}
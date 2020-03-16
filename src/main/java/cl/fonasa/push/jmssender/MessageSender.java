package cl.fonasa.push.jmssender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
@Component
public class MessageSender {
   @Autowired
   private JmsTemplate jmsTemplate;
   public void send(final String queue,
         final String msg){
      jmsTemplate.convertAndSend(queue, msg);
   }
}

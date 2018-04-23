package br.unipe.api.producer;


import br.unipe.api.library.entity.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * Classe responsavel por produzir emails e enviar ao servidor de mensageria
 */
@Component
public class EmailProducer {

    private static final Logger log = LoggerFactory.getLogger(EmailProducer.class);

    private JmsMessagingTemplate jmsMessagingTemplate;

    @Value("${spring.activemq.broker-url}")
    private String valor;


    private Queue queue;

    @Autowired
    public EmailProducer(JmsMessagingTemplate jmsMessagingTemplate, Queue queue) {
        this.jmsMessagingTemplate = jmsMessagingTemplate;
        this.queue = queue;
    }

    /**
     * Envia um objeto {@link Email} a cada 5 segundos para o servidor de mensageria
     */
    @Scheduled(fixedRate = 5000)
    public void send() {
        Email email = new Email(System.currentTimeMillis() + "email@remetente.com", System.currentTimeMillis() + "email@destinatario.com", "corpo do email");
        this.jmsMessagingTemplate.convertAndSend(this.queue, email);
        log.info("Email enviado: " + email);
    }


}

package br.unipe.api.consumer.listener;

import br.unipe.api.library.entity.Email;
import br.unipe.api.consumer.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @JmsListener(destination = "Emails")
    public void receive(Email email) {
        emailService.save(email);
    }

}

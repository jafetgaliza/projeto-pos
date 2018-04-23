package br.unipe.api.consumer.service;

import br.unipe.api.library.entity.Email;
import br.unipe.api.consumer.repository.EmailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmailService {


    private EmailRepository repository;

    @Autowired
    public EmailService(EmailRepository repository) {
        this.repository = repository;
    }

    public Iterable<Email> findAll() {
        return repository.findAll();
    }

    public Email save(Email email) {
        return repository.save(email);
    }

    public List<Email> findByDestinatario(String email) {
        return repository.findAllByDestinatario(email);
    }
}

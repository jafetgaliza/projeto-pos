package br.unipe.api.consumer.controller;


import br.unipe.api.library.entity.Email;
import br.unipe.api.consumer.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
public class EmailControler {

    private EmailService service;

    @Autowired
    public EmailControler(EmailService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Email>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Iterable<Email>> findByDestinatario(@PathVariable String email) {
        return ResponseEntity.ok(service.findByDestinatario(email));
    }
}

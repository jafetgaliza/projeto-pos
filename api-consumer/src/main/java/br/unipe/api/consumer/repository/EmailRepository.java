package br.unipe.api.consumer.repository;

import br.unipe.api.library.entity.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends CrudRepository<Email, Long> {

    List<Email> findAllByDestinatario(String destinatario);
}

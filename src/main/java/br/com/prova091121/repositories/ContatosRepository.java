package br.com.prova091121.repositories;

import br.com.prova091121.models.ContatosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContatosRepository extends JpaRepository<ContatosModel, Long> {
    Optional<ContatosModel> findByContatosEmail(String email);
}

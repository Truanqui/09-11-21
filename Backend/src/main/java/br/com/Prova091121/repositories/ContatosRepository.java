package br.com.Prova091121.repositories;

import br.com.Prova091121.models.ContatosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContatosRepository extends JpaRepository<ContatosModel, Long> {
    Optional<ContatosModel> findByContatosEmail(String email);
    Optional<ContatosModel> findByContatosTelefone(String telefone);
}

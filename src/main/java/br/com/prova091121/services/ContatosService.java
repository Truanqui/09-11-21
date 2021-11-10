package br.com.prova091121.services;


import br.com.prova091121.exceptions.ContatosNotFoundException;
import br.com.prova091121.exceptions.ContatosAlreadyExistsException;
import br.com.prova091121.models.ContatosModel;
import br.com.prova091121.repositories.ContatosRepository;
import lombok.extern.java.Log;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatosService {

    @Autowired
    private ContatosRepository repository;

    // Find all
    public List<ContatosModel> findAll(){
        List<ContatosModel> result = repository.findAll();
        return result.stream().map(x -> new ContatosModel(x)).collect(Collectors.toList());
    }

    //Post Contatos
    public ContatosModel insert(ContatosModel contatos){

        Optional<ContatosModel> contatosModel = repository.findByContatosEmail(contatos.getContatosEmail());
        if (contatosModel.isPresent()){
            System.out.println("Contato already exists");
            throw new ServiceException("Contato already exists");
        }
        ContatosModel unit = new ContatosModel();

        unit.setIdContatos(contatos.getIdContatos());
        unit.setContatosName(contatos.getContatosName());
        unit.setContatosEmail(contatos.getContatosEmail());
        unit.setContatosTelefone(contatos.getContatosTelefone());

        unit = repository.save(unit);

        return unit;
    }

    //Find by Id
    public ContatosModel findById(Long id){
        Optional<ContatosModel> result = repository.findById(id);
        return result.orElseThrow(() -> new ContatosNotFoundException("Contato not found. Please try again"));
    }

    //Edit Cotatos
    public ContatosModel edit(Long id,ContatosModel update){
        ContatosModel updated = findById(id);

        updated.setIdContatos(update.getIdContatos());
        updated.setContatosName(update.getContatosName());
        updated.setContatosEmail(update.getContatosEmail());
        updated.setContatosTelefone(update.getContatosTelefone());

        repository.save(update);

        return updated;
    }
    public void deleteById(Long id) { repository.delete(findById(id)); }
}

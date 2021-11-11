package br.com.Prova091121.services;

import br.com.Prova091121.exceptions.ContatosNotFoundException;
import br.com.Prova091121.exceptions.ContatosAlreadyExistsException;
import br.com.Prova091121.models.ContatosModel;
import br.com.Prova091121.repositories.ContatosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatosService {

    @Autowired
    private ContatosRepository repository;

    // INDEX
    public List<ContatosModel> findAll(){
        List<ContatosModel> result = repository.findAll();
        return result.stream().map(x -> new ContatosModel(x)).collect(Collectors.toList());
    }

    //Find by Id
    public ContatosModel findById(Long id){
        Optional<ContatosModel> result = repository.findById(id);
        return result.orElseThrow(() -> new ContatosNotFoundException("Contato not found. Please try again"));
    }
    //SHOW
    public ContatosModel show(String email){
        Optional<ContatosModel> result = repository.findByContatosEmail(email);
        return result.orElseThrow(() -> new ContatosNotFoundException("Contato not found. Please try again"));
    }
    //CREATE
    public ContatosModel insert(ContatosModel cotatos){

        Optional<ContatosModel> contatosEmail = repository.findByContatosEmail(cotatos.getContatosEmail());
        if (contatosEmail.isPresent()){
            throw new ContatosAlreadyExistsException("Contato already exists");
        }
        Optional<ContatosModel> contatosTelefone = repository.findByContatosTelefone(cotatos.getContatosTelefone());
        if (contatosTelefone.isPresent()){
            throw new ContatosAlreadyExistsException("Contato already exists");
        }

        ContatosModel unit = new ContatosModel();
        unit.setContatosName(cotatos.getContatosName());
        unit.setContatosEmail(cotatos.getContatosEmail());
        unit.setContatosTelefone(cotatos.getContatosTelefone());

        unit = repository.save(unit);

        return unit;
    }

    //UPDATE
    public ContatosModel edit(Long id,ContatosModel update){
        ContatosModel updated = findById(id);

        Optional<ContatosModel> contatosEmail = repository.findByContatosEmail(update.getContatosEmail());
        if (contatosEmail.isPresent()){
            throw new ContatosAlreadyExistsException("Contato already exists");
        }

        Optional<ContatosModel> contatosTelefone = repository.findByContatosTelefone(update.getContatosTelefone());
        if (contatosTelefone.isPresent()){
            throw new ContatosAlreadyExistsException("Contato aleready exists");
        }

        updated.setIdContatos(update.getIdContatos());
        updated.setContatosName(update.getContatosName());
        updated.setContatosEmail(update.getContatosEmail());
        updated.setContatosTelefone(update.getContatosTelefone());

        repository.save(update);

        return updated;
    }
    //DELETE
    public void deleteById(Long id) { repository.delete(findById(id)); }
}

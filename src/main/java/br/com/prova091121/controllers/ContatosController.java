package br.com.prova091121.controllers;

import br.com.prova091121.models.ContatosModel;
import br.com.prova091121.repositories.ContatosRepository;
import br.com.prova091121.services.ContatosService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/contatos")
public class ContatosController {

    @Autowired
    private ContatosService service;

    @GetMapping
    public ResponseEntity<List<ContatosModel>> findAll(){
        List<ContatosModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ContatosModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ContatosModel> insert(@RequestBody ContatosModel entity) {
        try {
            ContatosModel obj = service.insert(entity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getIdContatos()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } catch (ServiceException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok(id);
    }
}

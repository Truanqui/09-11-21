package br.com.Prova091121.controllers;

import br.com.Prova091121.models.ContatosModel;
import br.com.Prova091121.services.ContatosService;
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

    //INDEX
    @GetMapping
    public ResponseEntity<List<ContatosModel>> findAll(){
        List<ContatosModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }
    //Find by Id
    @GetMapping(path = "/{id}")
    public ResponseEntity<ContatosModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    //SHOW
    @GetMapping(path = "/{email}")
    public ResponseEntity<ContatosModel> show(@PathVariable String email){
        return ResponseEntity.ok(service.show(email));
    }
    //CREATE
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
    //EDIT
    @PutMapping(path = "/{id}")
    public ResponseEntity<ContatosModel> editContatos(@PathVariable Long id, @RequestBody ContatosModel update){
        return ResponseEntity.ok(service.edit(id, update));
    }
    //DELETE
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("Contato" + id + "deleted!");
    }
}

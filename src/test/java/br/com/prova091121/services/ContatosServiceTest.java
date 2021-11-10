package br.com.prova091121.services;

import br.com.prova091121.exceptions.ContatosAlreadyExistsException;
import br.com.prova091121.exceptions.ContatosNotFoundException;
import br.com.prova091121.models.ContatosModel;
import br.com.prova091121.repositories.ContatosRepository;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContatosServiceTest {

    @Autowired
    ContatosService service;

    @MockBean
    ContatosRepository repository;

    @Test
    @DisplayName("Retorna sucesso quando buscar um contato")
    public void shouldReturnSucess_WhenFindContato(){
        Long id = 1L;
        ContatosModel contatoTest = service.findById(id);
        Assertions.assertEquals(contatoTest.getIdContatos(), id);
    }

    @Test
    @DisplayName("Retorna sucesso quando inserir contato")
    public void shouldReturnSucess_WhenInsideContato(){
       ContatosModel contatoTest = new ContatosModel(1L,"João","Joao123@gmail.com","(00)111222333");
       Assertions.assertDoesNotThrow(() -> service.insert(contatoTest) );
    }
    @Test
    @DisplayName("Retorna uma exception quando inserir contato existente")
    public void shouldReturnException_WhenInsideExistentContatos(){
        ContatosModel contatoTest = new ContatosModel(1L,"José","Jose123@gmail.com ","(11)222333444");
    }
    
    @BeforeEach
    public void setup(){
        ContatosModel contatos = new ContatosModel(1L,"John","John123@gmail.com","(22)333444555");
        Mockito.when(repository.findByContatosEmail(contatos.getContatosEmail())).thenReturn(java.util.Optional.of(contatos));
    }
}

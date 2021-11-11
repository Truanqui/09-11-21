package br.com.testes.services;

import br.com.Prova091121.exceptions.ContatosAlreadyExistsException;
import br.com.Prova091121.exceptions.ContatosNotFoundException;

import br.com.Prova091121.models.ContatosModel;
import br.com.Prova091121.repositories.ContatosRepository;

import br.com.Prova091121.services.ContatosService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
public class ContatosServiceTest {

    @Mock
    ContatosService contatosService;

    @MockBean
    ContatosRepository repository;

    @Test
    @DisplayName("Retorna sucesso quando buscar um contato")
    public void shouldReturnSucess_WhenFindContato(){
        ContatosModel contatoTest = contatosService.findById(1L);
        Assertions.assertEquals(contatoTest.getContatosName(), "Johann");
    }

    @Test
    @DisplayName("Retorna sucesso quando inserir contato")
    public void shouldReturnSucess_WhenInsideContato(){
       ContatosModel contatoTest = new ContatosModel(1L,"João","Joao123@gmail.com","(00)111222333");
       Assertions.assertDoesNotThrow(() -> contatosService.insert(contatoTest) );
    }

    @Test
    @DisplayName("Retorna não econtrado quando buscar um contato")
    public void shoulReturnNotSucess_WhenFIndContato(){
        Assertions.assertThrows(ContatosNotFoundException.class, () -> contatosService.findById(3L) );
    }

    @Test
    @DisplayName("Retorna uma exception quando inserir contato existente")
    public void shouldReturnException_WhenInsideExistentContatos(){
        ContatosModel contatoTest = new ContatosModel(1L,"José","Jose123@gmail.com ","(11)222333444");
    }
    @Test
    @DisplayName("Retorna exception quando inserir contato com telefone que já foi cadastrado")
    public void shouldReturnException_WhenInsideContatoWithExistentTelefone(){
        ContatosModel cotatosTest = new ContatosModel(2L,"Jennifer","Jennifer123@gmail.com","(22)333444555");
        Assertions.assertThrows(ContatosAlreadyExistsException.class, () -> contatosService.insert(cotatosTest) );
    }
    @Test
    @DisplayName("Retorna exception quando inserir contato com email que já foi cadastrado")
    public void shouldReturnException_WhenInsideContactWithExistentEmail(){
        ContatosModel cotatosTest =  new ContatosModel(3L,"James","John123@gmail.com","(33)444555666");
        Assertions.assertThrows(ContatosAlreadyExistsException.class, () -> contatosService.insert(cotatosTest) );
    }
    @BeforeEach
    public void setup(){
        ContatosModel contatos = new ContatosModel(1L,"John","John123@gmail.com","(22)333444555");
        Mockito.when(repository.findByContatosEmail(contatos.getContatosEmail())).thenReturn(java.util.Optional.of(contatos));
    }
}

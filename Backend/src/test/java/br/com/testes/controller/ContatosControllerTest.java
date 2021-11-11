package br.com.testes.controller;

import br.com.Prova091121.controllers.ContatosController;
import br.com.Prova091121.models.ContatosModel;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContatosControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ContatosController controller;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Retorna status code 201 quando criar contato corretamente")
    public void shouldReturnStatus201_WhenCreateContatoWithCorrectData() throws Exception{
        ContatosModel contato = new ContatosModel(1L,"Jacob","Jacob123@gmail.com","(44)555666777");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(contato);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contatos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    @Test
    @DisplayName("Retorna status code 400 quando criar contato incorretamente")
    public void shouldReturnStatusCode400_WhenCreateContatoWithIncorrectData() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/contatos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    @DisplayName("Retorna status code 422 quando criar contato com email já existente")
    public void shouldReturnStatusCode422_WhenCreateContatosWithExistentEmail() throws Exception{
        ContatosModel existingCotatos = new ContatosModel(1L,"Johann","Johann123@gmail.com","(44)555666777");
        ContatosModel contato = new ContatosModel(1L,"Julia","Julia123@gmail.com","(00)999888777");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(existingCotatos);
        String json1 = mapper.writeValueAsString(contato);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contatos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contatos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json1))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }
    @Test
    @DisplayName("Retorna status code 200 quando buscar contato que existe pelo email")
    public void shouldReturnStatusCode200_WhenSearchExistingContatoByEmail() throws Exception{
        ContatosModel contato = new ContatosModel(1L,"Jack","John123@gmail.com","(33)555777999");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(contato);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contatos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/contatos/John123@gmail.com","(33)555777999"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @DisplayName("Retorna status code 200 quando buscar contato que existe pelo id")
    public void shouldReturnStatusCode200_WhenSearchExistingContatoById() throws Exception{
        ContatosModel contato = new ContatosModel(1L,"John","John123@gmail.com","(22)333444555");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(contato);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contatos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/contatos/id/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

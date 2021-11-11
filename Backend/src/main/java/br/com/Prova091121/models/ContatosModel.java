package br.com.Prova091121.models;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cotatos")
public class ContatosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContatos;

    private String contatosName;
    private String contatosEmail;
    private String contatosTelefone;

    public ContatosModel(ContatosModel entity){
        idContatos = entity.getIdContatos();
        contatosName = entity.getContatosName();
        contatosEmail = entity.getContatosEmail();
        contatosTelefone = entity.getContatosTelefone();
    }
}

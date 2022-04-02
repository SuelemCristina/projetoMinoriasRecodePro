package br.com.squad.pindorama.domain.pindorama.model;

import br.com.squad.pindorama.infra.auth.model.User;
import br.com.squad.pindorama.domain.pindorama.model.Endereco;
import br.com.squad.pindorama.domain.pindorama.model.Pacote;
import br.com.squad.pindorama.domain.pindorama.model.Artesanato;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    private String id;

    private String nome;

    private String telefone;

    private Date dataNascimento;

    private String cpf;

    private Endereco endereco;

    @DBRef
    private User user;

    @DBRef
    private Set<Artesanato> artesanatos = new HashSet<>();

    @DBRef
    private Set<Pacote> pacotes = new HashSet<>();

}

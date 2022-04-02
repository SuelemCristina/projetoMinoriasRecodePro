package br.com.squad.pindorama.domain.pindorama.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Contato {

  @Id
  private String id;

  private String nome;

  private String email;

  private String mensagem;

}

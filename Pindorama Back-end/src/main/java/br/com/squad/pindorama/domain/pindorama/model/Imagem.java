package br.com.squad.pindorama.domain.pindorama.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Imagem {

  private String id;

  private String nome;

  private String dados;

}

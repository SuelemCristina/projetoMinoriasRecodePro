package br.com.squad.pindorama.domain.pindorama.model;

import java.time.Instant;
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
public class Pacote {

  @Id
  private String id;

  private String descricao;

  private Double valor;

  private Date dataIda;

  private Date dataVolta;

  @DBRef
  private Aldeia aldeia;

  @DBRef
  private Imagem imagem;

}

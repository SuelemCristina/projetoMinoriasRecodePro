package br.com.squad.pindorama.infra.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

  @Id
  private String id;
  private EnumRole name;

  public Role(EnumRole name) {
    this.name = name;
  }
}

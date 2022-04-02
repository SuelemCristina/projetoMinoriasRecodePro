package br.com.squad.pindorama.domain.pindorama.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

  private String logradouro;

  private String numero;

  private String complemento;

  private String bairro;

  private String cidade;

  private String estado;
}

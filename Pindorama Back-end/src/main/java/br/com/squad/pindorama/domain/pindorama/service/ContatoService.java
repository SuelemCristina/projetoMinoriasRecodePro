package br.com.squad.pindorama.domain.pindorama.service;

import br.com.squad.pindorama.domain.pindorama.model.Contato;
import java.util.List;
import java.util.Optional;

public interface ContatoService {

  List<Contato> findAll();

  Optional<Contato> find(String id);

  Contato create(Contato Contato);

  Optional<Contato> update(String id, Contato Contato);

  void delete(String id);



}

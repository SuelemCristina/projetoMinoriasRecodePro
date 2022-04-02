package br.com.squad.pindorama.domain.pindorama.service;

import br.com.squad.pindorama.domain.pindorama.model.Pacote;
import java.util.List;
import java.util.Optional;

public interface PacoteService {

  List<Pacote> findAll();

  Optional<Pacote> find(String id);

  Pacote create(Pacote Pacote);

  Optional<Pacote> update(String id, Pacote Pacote);

  void delete(String id);



}

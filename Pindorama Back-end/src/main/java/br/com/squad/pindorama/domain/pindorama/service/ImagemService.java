package br.com.squad.pindorama.domain.pindorama.service;

import br.com.squad.pindorama.domain.pindorama.model.Imagem;
import java.util.List;
import java.util.Optional;

public interface ImagemService {

  List<Imagem> findAll();

  Optional<Imagem> find(String id);

  Imagem create(Imagem Imagem);

  Optional<Imagem> update(String id, Imagem Imagem);

  void delete(String id);



}

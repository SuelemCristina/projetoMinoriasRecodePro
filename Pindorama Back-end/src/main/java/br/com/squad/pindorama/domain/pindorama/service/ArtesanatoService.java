package br.com.squad.pindorama.domain.pindorama.service;

import br.com.squad.pindorama.domain.pindorama.model.Artesanato;
import java.util.List;
import java.util.Optional;

public interface ArtesanatoService {

  List<Artesanato> findAll();

  Optional<Artesanato> find(String id);

  Artesanato create(Artesanato Artesanato);

  Optional<Artesanato> update(String id, Artesanato Artesanato);

  void delete(String id);



}

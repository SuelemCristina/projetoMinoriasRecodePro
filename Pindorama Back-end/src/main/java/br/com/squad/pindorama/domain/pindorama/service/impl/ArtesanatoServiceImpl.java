package br.com.squad.pindorama.domain.pindorama.service.impl;

import br.com.squad.pindorama.domain.pindorama.model.Artesanato;
import br.com.squad.pindorama.domain.pindorama.repository.ArtesanatoRepository;
import br.com.squad.pindorama.domain.pindorama.service.ArtesanatoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArtesanatoServiceImpl implements ArtesanatoService {

  @Autowired
  private ArtesanatoRepository artesanatoRepository;

  @Override
  public List<Artesanato> findAll() {
    return artesanatoRepository.findAll();
  }

  @Override
  public Optional<Artesanato> find(String id) {
    return artesanatoRepository.findById(id);
  }

  @Override
  public Artesanato create(Artesanato artesanato) {
    return artesanatoRepository.save(artesanato);
  }

  @Override
  public Optional<Artesanato> update(String id, Artesanato artesanato) {
   Optional<Artesanato> artesanatoEncontrado = artesanatoRepository.findById(id);
    artesanatoEncontrado.get().setNome(artesanato.getNome());
    artesanatoEncontrado.get().setDescricao(artesanato.getDescricao());
    artesanatoEncontrado.get().setValor(artesanato.getValor());
    artesanatoEncontrado.get().setImagem(artesanato.getImagem());

    artesanatoRepository.save(artesanatoEncontrado.get());

    return artesanatoEncontrado;
  }

  @Override
  public void delete(String id) {
    artesanatoRepository.deleteById(id);
  }
}

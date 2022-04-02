package br.com.squad.pindorama.domain.pindorama.service.impl;

import br.com.squad.pindorama.domain.pindorama.model.Imagem;
import br.com.squad.pindorama.domain.pindorama.repository.ImagemRepository;
import br.com.squad.pindorama.domain.pindorama.service.ImagemService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImagemServiceImpl implements ImagemService {

  @Autowired
  private ImagemRepository imagemRepository;

  @Override
  public List<Imagem> findAll() {
    return imagemRepository.findAll();
  }

  @Override
  public Optional<Imagem> find(String id) {
    return imagemRepository.findById(id);
  }

  @Override
  public Imagem create(Imagem imagem) {
    return imagemRepository.save(imagem);
  }

  @Override
  public Optional<Imagem> update(String id, Imagem imagem) {
   Optional<Imagem> imagemEncontrada = imagemRepository.findById(id);
    imagemEncontrada.get().setNome(imagem.getNome());
    imagemEncontrada.get().setDados(imagem.getDados());
    
    imagemRepository.save(imagemEncontrada.get());

    return imagemEncontrada;
  }

  @Override
  public void delete(String id) {
    imagemRepository.deleteById(id);
  }
}

package br.com.squad.pindorama.domain.pindorama.service.impl;

import br.com.squad.pindorama.domain.pindorama.model.Pacote;
import br.com.squad.pindorama.domain.pindorama.repository.PacoteRepository;
import br.com.squad.pindorama.domain.pindorama.service.PacoteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PacoteServiceImpl implements PacoteService {

  @Autowired
  private PacoteRepository pacoteRepository;

  @Override
  public List<Pacote> findAll() {
    return pacoteRepository.findAll();
  }

  @Override
  public Optional<Pacote> find(String id) {
    return pacoteRepository.findById(id);
  }

  @Override
  public Pacote create(Pacote pacote) {
    return pacoteRepository.save(pacote);
  }

  @Override
  public Optional<Pacote> update(String id, Pacote pacote) {
   Optional<Pacote> pacoteEncontrado = pacoteRepository.findById(id);
    pacoteEncontrado.get().setDescricao(pacote.getDescricao());
    pacoteEncontrado.get().setImagem(pacote.getImagem());
    pacoteEncontrado.get().setValor(pacote.getValor());
    pacoteEncontrado.get().setAldeia(pacote.getAldeia());
    pacoteEncontrado.get().setDataIda(pacote.getDataIda());
    pacoteEncontrado.get().setDataVolta(pacote.getDataVolta());
    
    pacoteRepository.save(pacoteEncontrado.get());

    return pacoteEncontrado;
  }

  @Override
  public void delete(String id) {
    pacoteRepository.deleteById(id);
  }
}

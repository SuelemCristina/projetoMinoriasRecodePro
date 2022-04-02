package br.com.squad.pindorama.domain.pindorama.service.impl;

import br.com.squad.pindorama.domain.pindorama.model.Aldeia;
import br.com.squad.pindorama.domain.pindorama.repository.AldeiaRepository;
import br.com.squad.pindorama.domain.pindorama.service.AldeiaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AldeiaServiceImpl implements AldeiaService {

  @Autowired
  private AldeiaRepository aldeiaRepository;

  @Override
  public List<Aldeia> findAll() {
    return aldeiaRepository.findAll();
  }

  @Override
  public Optional<Aldeia> findById(String id) {
    return aldeiaRepository.findById(id);
  }

  @Override
  public Aldeia create(Aldeia aldeia) {
    return aldeiaRepository.save(aldeia);
  }

  @Override
  public Optional<Aldeia> update(String id, Aldeia aldeia) {
   Optional<Aldeia> aldeiaEncontrada = aldeiaRepository.findById(id);
    aldeiaEncontrada.get().setNomeAldeia(aldeia.getNomeAldeia());
    aldeiaEncontrada.get().setResponsavel(aldeia.getResponsavel());
    aldeiaEncontrada.get().setEndereco(aldeia.getEndereco());
    aldeiaEncontrada.get().setTelefone(aldeia.getTelefone());

    aldeiaRepository.save(aldeiaEncontrada.get());

    return aldeiaEncontrada;
  }

  @Override
  public void delete(String id) {
    aldeiaRepository.deleteById(id);
  }

  @Override
  public Aldeia findByUserId(String userId) {
    return aldeiaRepository.findByUserId(userId);
  }
}

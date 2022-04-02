package br.com.squad.pindorama.domain.pindorama.service.impl;

import br.com.squad.pindorama.domain.pindorama.model.Contato;
import br.com.squad.pindorama.domain.pindorama.repository.ContatoRepository;
import br.com.squad.pindorama.domain.pindorama.service.ContatoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContatoServiceImpl implements ContatoService {

  @Autowired
  private ContatoRepository contatoRepository;

  @Override
  public List<Contato> findAll() {
    return contatoRepository.findAll();
  }

  @Override
  public Optional<Contato> find(String id) {
    return contatoRepository.findById(id);
  }

  @Override
  public Contato create(Contato contato) {
    return contatoRepository.save(contato);
  }

  @Override
  public Optional<Contato> update(String id, Contato contato) {
   Optional<Contato> contatoEncontrado = contatoRepository.findById(id);
    contatoEncontrado.get().setNome(contato.getNome());
    contatoEncontrado.get().setEmail(contato.getEmail());
    contatoEncontrado.get().setMensagem(contato.getMensagem());
    
    contatoRepository.save(contatoEncontrado.get());

    return contatoEncontrado;
  }

  @Override
  public void delete(String id) {
    contatoRepository.deleteById(id);
  }
}

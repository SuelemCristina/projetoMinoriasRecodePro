package br.com.squad.pindorama.domain.pindorama.controller;

import br.com.squad.pindorama.domain.pindorama.model.Contato;
import br.com.squad.pindorama.domain.pindorama.service.ContatoService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contatos")
public class ContatoController {

  @Autowired
  private ContatoService contatoService;

  @GetMapping
  public List<Contato> findAll(){
    return contatoService.findAll();
  }

  @GetMapping("/{id}")
  public Contato findById(@PathVariable String id){
    return contatoService.find(id).orElseThrow(RuntimeException::new);
  }

  @PostMapping
  public ResponseEntity create (@RequestBody Contato contato) throws URISyntaxException {
    Contato contatoCriado = contatoService.create(contato);
    return ResponseEntity.created(new URI("contatos/" + contatoCriado.getId())).body(contatoCriado);
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@PathVariable String id, @RequestBody Contato contato){
    return ResponseEntity.ok(contatoService.update(id, contato));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable String id){
    contatoService.delete(id);
    return ResponseEntity.ok().build();
  }

}

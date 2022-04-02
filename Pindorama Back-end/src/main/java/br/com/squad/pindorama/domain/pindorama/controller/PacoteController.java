package br.com.squad.pindorama.domain.pindorama.controller;

import br.com.squad.pindorama.domain.pindorama.model.Pacote;
import br.com.squad.pindorama.domain.pindorama.service.PacoteService;
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
@RequestMapping("/pacotes")
public class PacoteController {

  @Autowired
  private PacoteService pacoteService;

  @GetMapping
  public List<Pacote> findAll(){
    return pacoteService.findAll();
  }

  @GetMapping("/{id}")
  public Pacote findById(@PathVariable String id){
    return pacoteService.find(id).orElseThrow(RuntimeException::new);
  }

  @PostMapping
  public ResponseEntity create (@RequestBody Pacote pacote) throws URISyntaxException {
    Pacote pacoteCriado = pacoteService.create(pacote);
    return ResponseEntity.created(new URI("pacotes/" + pacoteCriado.getId())).body(pacoteCriado);
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@PathVariable String id, @RequestBody Pacote pacote){
    return ResponseEntity.ok(pacoteService.update(id, pacote));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable String id){
    pacoteService.delete(id);
    return ResponseEntity.ok().build();
  }

}

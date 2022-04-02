package br.com.squad.pindorama.domain.pindorama.controller;

import br.com.squad.pindorama.domain.pindorama.model.Imagem;
import br.com.squad.pindorama.domain.pindorama.service.ImagemService;
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
@RequestMapping("/imagens")
public class ImagemController {

  @Autowired
  private ImagemService imagemService;

  @GetMapping
  public List<Imagem> findAll(){
    return imagemService.findAll();
  }

  @GetMapping("/{id}")
  public Imagem findById(@PathVariable String id){
    return imagemService.find(id).orElseThrow(RuntimeException::new);
  }

  @PostMapping
  public ResponseEntity create (@RequestBody Imagem imagem) throws URISyntaxException {
    Imagem imagemCriada = imagemService.create(imagem);
    return ResponseEntity.created(new URI("imagens/" + imagemCriada.getId())).body(imagemCriada);
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@PathVariable String id, @RequestBody Imagem imagem){
    return ResponseEntity.ok(imagemService.update(id, imagem));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable String id){
    imagemService.delete(id);
    return ResponseEntity.ok().build();
  }

}

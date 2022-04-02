package br.com.squad.pindorama.domain.pindorama.controller;

import br.com.squad.pindorama.domain.pindorama.model.Aldeia;
import br.com.squad.pindorama.domain.pindorama.model.Artesanato;
import br.com.squad.pindorama.domain.pindorama.service.ArtesanatoService;
import br.com.squad.pindorama.domain.pindorama.service.impl.AldeiaServiceImpl;
import br.com.squad.pindorama.domain.pindorama.service.impl.ArtesanatoServiceImpl;
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
@RequestMapping("/artesanatos")
public class ArtesanatoController {

  @Autowired
  private ArtesanatoService artesanatoService;

  @GetMapping
  public List<Artesanato> findAll(){
    return artesanatoService.findAll();
  }

  @GetMapping("/{id}")
  public Artesanato findById(@PathVariable String id){
    return artesanatoService.find(id).orElseThrow(RuntimeException::new);
  }

  @PostMapping
  public ResponseEntity create (@RequestBody Artesanato artesanato) throws URISyntaxException {
    Artesanato artesanatoCriado = artesanatoService.create(artesanato);
    return ResponseEntity.created(new URI("artesanatos/" + artesanatoCriado.getId())).body(artesanatoCriado);
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@PathVariable String id, @RequestBody Artesanato artesanato){
    return ResponseEntity.ok(artesanatoService.update(id, artesanato));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable String id){
    artesanatoService.delete(id);
    return ResponseEntity.ok().build();
  }

}

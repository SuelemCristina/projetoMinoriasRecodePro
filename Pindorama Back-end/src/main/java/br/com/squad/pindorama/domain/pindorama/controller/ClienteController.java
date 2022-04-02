package br.com.squad.pindorama.domain.pindorama.controller;

import br.com.squad.pindorama.domain.pindorama.model.Cliente;
import br.com.squad.pindorama.domain.pindorama.service.ClienteService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable String id){
        return clienteService.find(id).orElseThrow(RuntimeException::new);
    }

    @GetMapping("/user/{userId}")
    public Optional<Cliente> findByUserId(@PathVariable String userId){
        return clienteService.findByUserId(userId);
    }

    @PostMapping
    public ResponseEntity create (@RequestBody Cliente cliente){
        Cliente clienteCriado = clienteService.create(cliente);
        return ResponseEntity.ok(clienteCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.update(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

}

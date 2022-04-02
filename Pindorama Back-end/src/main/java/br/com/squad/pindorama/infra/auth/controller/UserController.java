package br.com.squad.pindorama.infra.auth.controller;

import br.com.squad.pindorama.domain.pindorama.model.Aldeia;
import br.com.squad.pindorama.domain.pindorama.model.Cliente;
import br.com.squad.pindorama.domain.pindorama.repository.AldeiaRepository;
import br.com.squad.pindorama.domain.pindorama.repository.ClienteRepository;
import br.com.squad.pindorama.infra.auth.model.User;
import br.com.squad.pindorama.infra.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AldeiaRepository aldeiaRepository;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('ADMIN') or hasRole('ALDEIA')")
    @GetMapping("/buscarUser/{id}")
    public ResponseEntity<User> get(@PathVariable String id) {
        try {
            User user = userService.get(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('ADMIN') or hasRole('ALDEIA')")
    @PutMapping("/alterarUser/{id}")
    public ResponseEntity<User> update(@RequestBody User newUser, @PathVariable String id) {
        try {
            userService.update(id, newUser);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('ADMIN') or hasRole('ALDEIA')")
    @DeleteMapping("/deleteUser/{id}")
    public String delete(@PathVariable String id) {
        User delUser = userService.get(id);
        Cliente cliente = clienteRepository.findByUserId(id);
        Aldeia aldeia = aldeiaRepository.findByUserId(id);
        if (cliente != null) {
            clienteRepository.delete(cliente);
        }else if (aldeia != null) {
            aldeiaRepository.delete(aldeia);
        }
        userService.delete(id);
        return "Cliente Excluido.";
    }
}

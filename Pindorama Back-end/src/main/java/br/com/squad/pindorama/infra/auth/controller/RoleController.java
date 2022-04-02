package br.com.squad.pindorama.infra.auth.controller;

import br.com.squad.pindorama.infra.auth.model.Role;
import br.com.squad.pindorama.infra.auth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

        @Autowired
        private RoleService roleService;

        @PostMapping({"/cadastrarRole"})
        public Role cadastrarRole(@RequestBody Role role) {
            return roleService.cadastrarRole(role);
        }

}

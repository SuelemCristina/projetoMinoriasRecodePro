package br.com.squad.pindorama.infra.auth.service;

import br.com.squad.pindorama.infra.auth.model.Role;
import br.com.squad.pindorama.infra.auth.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role cadastrarRole(Role role) {
        return roleRepository.save(role);
    }
}

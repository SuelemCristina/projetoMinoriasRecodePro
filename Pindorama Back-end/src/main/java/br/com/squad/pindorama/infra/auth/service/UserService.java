package br.com.squad.pindorama.infra.auth.service;

import br.com.squad.pindorama.infra.auth.model.EnumRole;
import br.com.squad.pindorama.infra.auth.model.Role;
import br.com.squad.pindorama.infra.auth.model.User;
import br.com.squad.pindorama.infra.auth.repository.RoleRepository;
import br.com.squad.pindorama.infra.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.squad.pindorama.infra.auth.model.EnumRole.*;


@Service
public class UserService {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private RoleRepository roleRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        public void initRoleAndUser() {
//            List<Role> roles = roleRepository.findAll();
//
//            if(roles.isEmpty()){
//                Role adminRole = new Role("ROLE_ADMIN");
//            roleRepository.save(adminRole);
//
//            Role clienterRole = new Role(ROLE_CLIENTE);
//            roleRepository.save(clienterRole);
//
//            Role aldeiaRole = new Role(ROLE_ALDEIA);
//            roleRepository.save(aldeiaRole);
//            }
        }

        public User save(User user){
            return userRepository.save(user);
        }
        public String getEncodedPassword(String password) {
            return passwordEncoder.encode(password);
        }

        public User get(String id) {
            return userRepository.findById(id).get();
        }

        public User getUsername(String email) {
            return userRepository.findByUsername(email).get();
        }

        public void update(String id, User newUser) {
            User oldUser = get(id);
//            if(newUser.getUsername() != oldUser.getUsername() && !newUser.getUsername().isEmpty()){
//                oldUser.setEmail(newUser.getEmail());
//            }else if(newUser.getPassword() != oldUser.getPassword() && !newUser.getPassword().isEmpty()){
//                oldUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
//            }
//            userRepository.save(oldUser);
        }


        public void delete(String id) {
            userRepository.deleteById(id);
        }


}

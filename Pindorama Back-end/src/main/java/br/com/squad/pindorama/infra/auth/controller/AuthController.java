package br.com.squad.pindorama.infra.auth.controller;

import br.com.squad.pindorama.infra.auth.model.EnumRole;
import br.com.squad.pindorama.infra.auth.model.Role;
import br.com.squad.pindorama.infra.auth.model.User;
import br.com.squad.pindorama.infra.payload.request.LoginRequest;
import br.com.squad.pindorama.infra.payload.request.SignupRequest;
import br.com.squad.pindorama.infra.payload.response.JwtResponse;
import br.com.squad.pindorama.infra.payload.response.MessageResponse;
import br.com.squad.pindorama.infra.auth.repository.RoleRepository;
import br.com.squad.pindorama.infra.auth.repository.UserRepository;
import br.com.squad.pindorama.infra.security.jwt.JwtUtils;
import br.com.squad.pindorama.infra.security.services.UserDetailsImpl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
        userDetails.getId(),
        userDetails.getUsername(),
        userDetails.getEmail(),
        roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Nome de usuário já utilizado!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Email já utilizado!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(),
        signUpRequest.getEmail(),
        encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

      strRoles.forEach(role -> {
        switch (role) {
          case "admin":
            Role adminRole = roleRepository.findByName(EnumRole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role não encontrada."));
            roles.add(adminRole);

            break;
          case "aldeia":
            Role aldeiaRole = roleRepository.findByName(EnumRole.ROLE_ALDEIA)
                .orElseThrow(() -> new RuntimeException("Error: Role não encontrada."));
            roles.add(aldeiaRole);

            break;
          default:
            Role clienteRole = roleRepository.findByName(EnumRole.ROLE_CLIENTE)
                .orElseThrow(() -> new RuntimeException("Error: Role não encontrada."));
            roles.add(clienteRole);

            break;
        }
      });

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("Usuario registrado com sucesso!"));
  }
}

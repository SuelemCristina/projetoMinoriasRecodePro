package br.com.squad.pindorama.infra.auth.repository;

import br.com.squad.pindorama.infra.auth.model.EnumRole;
import br.com.squad.pindorama.infra.auth.model.Role;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(EnumRole name);
}

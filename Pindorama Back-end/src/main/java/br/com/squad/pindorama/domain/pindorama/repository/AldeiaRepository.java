package br.com.squad.pindorama.domain.pindorama.repository;

import br.com.squad.pindorama.domain.pindorama.model.Aldeia;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AldeiaRepository extends MongoRepository<Aldeia, String> {
  Aldeia findByUserId(String userId);
}

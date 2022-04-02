package br.com.squad.pindorama.domain.pindorama.repository;

import br.com.squad.pindorama.domain.pindorama.model.Imagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepository extends MongoRepository<Imagem, String> {

}

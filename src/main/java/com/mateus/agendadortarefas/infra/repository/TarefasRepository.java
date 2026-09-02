package com.mateus.agendadortarefas.infra.repository;

import com.mateus.agendadortarefas.infra.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {
}

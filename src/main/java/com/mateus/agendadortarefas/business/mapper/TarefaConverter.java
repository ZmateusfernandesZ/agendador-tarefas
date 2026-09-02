package com.mateus.agendadortarefas.business.mapper;

import com.mateus.agendadortarefas.business.dto.TarefasDTO;
import com.mateus.agendadortarefas.infra.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);
    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}

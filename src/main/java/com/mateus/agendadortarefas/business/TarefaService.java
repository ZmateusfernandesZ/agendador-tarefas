package com.mateus.agendadortarefas.business;

import com.mateus.agendadortarefas.business.dto.TarefasDTO;
import com.mateus.agendadortarefas.business.mapper.TarefaConverter;
import com.mateus.agendadortarefas.infra.Enum.StatusNotificacao;
import com.mateus.agendadortarefas.infra.entity.TarefasEntity;
import com.mateus.agendadortarefas.infra.repository.TarefasRepository;
import com.mateus.agendadortarefas.infra.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefasRepository tarefasRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extractUsername(token.substring(7));

        dto.setCreatedAt(LocalDateTime.now());
        dto.setStatusTarefa(StatusNotificacao.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDTO(tarefasRepository.save(entity));

    }

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal){
        return tarefaConverter.paraListaTarefasDTO(tarefasRepository.findByDataEventoBetween(dataInicial, dataFinal));
    }

    public List<TarefasDTO> buscaTarefasEmail(String token){
        String email = jwtUtil.extractUsername(token.substring(7));
        return tarefaConverter.paraListaTarefasDTO(tarefasRepository.findByEmailUsuario(email));

    }


}

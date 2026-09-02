package com.mateus.agendadortarefas.controller;

import com.mateus.agendadortarefas.business.TarefaService;
import com.mateus.agendadortarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefasDTO>gravarTarefa(@RequestHeader("Authorization") String token, @RequestBody TarefasDTO dto){
        return ResponseEntity.ok(tarefaService.gravarTarefa(token, dto));
    }

}

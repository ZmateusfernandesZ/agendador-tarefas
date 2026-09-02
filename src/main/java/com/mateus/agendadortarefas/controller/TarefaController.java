package com.mateus.agendadortarefas.controller;

import com.mateus.agendadortarefas.business.TarefaService;
import com.mateus.agendadortarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefasDTO>gravarTarefa(@RequestHeader("Authorization") String token, @RequestBody TarefasDTO dto){
        return ResponseEntity.ok(tarefaService.gravarTarefa(token, dto));
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTO>> buscarListaTarefasPeriodo(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
                                                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal){
        return ResponseEntity.ok(tarefaService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal));
    }

    @GetMapping
    public ResponseEntity<List<TarefasDTO>> buscaTarefasPorEmail(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(tarefaService.buscaTarefasEmail(token));
    }
}

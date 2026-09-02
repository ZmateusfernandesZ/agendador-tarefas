package com.mateus.agendadortarefas.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mateus.agendadortarefas.infra.Enum.StatusNotificacao;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTO {
    private String id;
    private String nomeTarefa;
    private String descricao;
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime updatedAt;
    private StatusNotificacao statusTarefa;
}

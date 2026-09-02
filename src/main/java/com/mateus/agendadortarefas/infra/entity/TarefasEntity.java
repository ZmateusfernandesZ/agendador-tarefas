package com.mateus.agendadortarefas.infra.entity;

import com.mateus.agendadortarefas.infra.Enum.StatusNotificacao;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("tarefas")
public class TarefasEntity {

    @Id
    private String id;
    private String nomeTarefa;
    private String descricao;
    private LocalDateTime createdAt;
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime updatedAt;
    private StatusNotificacao statusTarefa;
}

package com.senai.ApiManeasy.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ChamadoDto(
        String anexo,
        String chapa_usuario,
        Date data_criacao,
        Date data_inicio,
        Date data_termino,
        String descricao_chamado,
        String nome_atendente,
        String nome_solicitante,
        String setor
) {}

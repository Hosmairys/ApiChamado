package com.senai.ApiManeasy.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record ChamadoDto(
        @NotBlank String nome_solicitante,
        String setor,
        @NotBlank String chapa_usuario,
        @NotBlank String nome_atendente,
        String descricao_chamado,
        String anexo,
        Date data_inicio,
        Date data_termino


) {}

package com.senai.ApiManeasy.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record ChamadoDto(
        MultipartFile anexo,
        String chapa_usuario,
        Date data_criacao,
        Date data_inicio,
        Date data_termino,
        String descricao_chamado,
        String nome_atendente,
        String nome_solicitante,
        String setor

) {}

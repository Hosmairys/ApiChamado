package com.senai.ApiManeasy.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_chamado")
public class ChamadoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_chamado", nullable = false)
    private UUID id;

    private String setor;
    private String nome_solicitante;
    private String chapa_usuario;
    private String nome_atendente;
    private Date data_criacao;
    private Date data_inicio;
    private Date data_termino;
    private String descricao_chamado;
    private String anexo;
}
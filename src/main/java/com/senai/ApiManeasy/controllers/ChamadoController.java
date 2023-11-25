package com.senai.ApiManeasy.controllers;

import com.senai.ApiManeasy.models.ChamadoModel;
import com.senai.ApiManeasy.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/chamado", produces = {"application/json"})
public class ChamadoController {

    @Autowired
    ChamadoRepository chamadoRepository;

    @GetMapping
    public ResponseEntity<List<ChamadoModel>> listarChamados(){
        return ResponseEntity.status(HttpStatus.OK).body(chamadoRepository.findAll());
    }

}

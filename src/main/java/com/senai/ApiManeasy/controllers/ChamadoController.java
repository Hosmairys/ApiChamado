package com.senai.ApiManeasy.controllers;

import com.senai.ApiManeasy.dtos.ChamadoDto;
import com.senai.ApiManeasy.models.ChamadoModel;
import com.senai.ApiManeasy.repositories.ChamadoRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/chamado", produces = {"application/json"})
public class ChamadoController {

    @Autowired
    ChamadoRepository chamadoRepository;

    @GetMapping
    public ResponseEntity<List<ChamadoModel>> listarChamados(){
        return ResponseEntity.status(HttpStatus.OK).body(chamadoRepository.findAll());
    }

    @GetMapping("/{idChamado}")
    public ResponseEntity<Object> buscarChamadoId(@PathVariable(value = "idChamado")UUID id){
        Optional<ChamadoModel> chamadoBuscado = chamadoRepository.findById(id);

        if (chamadoBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chamado no encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(chamadoBuscado.get());
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarChamado(@RequestBody @Valid ChamadoDto dadosRecibidos){
         ChamadoModel chamadoModel = new ChamadoModel();
        BeanUtils.copyProperties(dadosRecibidos, chamadoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(chamadoRepository.save(chamadoModel));
    }


}

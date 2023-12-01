package com.senai.ApiManeasy.controllers;

import com.senai.ApiManeasy.dtos.ChamadoDto;
import com.senai.ApiManeasy.models.ChamadoModel;
import com.senai.ApiManeasy.repositories.ChamadoRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.temporario.api.services.FileUploadService;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/chamado", produces = {"application/json"})
public class ChamadoController {

    @Autowired
    ChamadoRepository chamadoRepository;

    @Autowired
    FileUploadService fileUploadService;



    @GetMapping
    public ResponseEntity<List<ChamadoModel>> listarChamados() {
        return ResponseEntity.status(HttpStatus.OK).body(chamadoRepository.findAll());
    }

    @GetMapping("/{id_chamado}")
    public ResponseEntity<Object> buscarChamadoId(@PathVariable(value = "id_chamado") UUID id) {
        Optional<ChamadoModel> chamadoBuscado = chamadoRepository.findById(id);

        if (chamadoBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chamado no encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(chamadoBuscado.get());
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarChamado(@RequestBody @Valid ChamadoDto dadosRecibidos) {

        ChamadoModel chamadoModel = new ChamadoModel();
        BeanUtils.copyProperties(dadosRecibidos, chamadoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(chamadoRepository.save(chamadoModel));
    }

    @PutMapping(value = "/{id_chamado}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> editarChamado(@PathVariable(value = "id_chamado") UUID id, @ModelAttribute @Valid ChamadoDto chamadoDto){
    Optional<ChamadoModel> chamadoBusacado = chamadoRepository.findById(id);

        if (chamadoBusacado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chamado não encontrado");
        }

        ChamadoModel chamadoModel = chamadoBusacado.get();
        BeanUtils.copyProperties(chamadoDto, chamadoModel);

        String urlImg;

        try{
            urlImg = fileUploadService.fazerUpload(chamadoDto.anexo());

        }catch (IOException e){
            throw new RuntimeException(e);
        }

        usuarioModel.setUrl_img(urlImg);

        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuarioModel));

    }

}

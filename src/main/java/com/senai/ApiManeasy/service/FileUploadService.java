package com.senai.ApiManeasy.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FileUploadService {
    private final Path diretorioImg = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img");

    public String fazerUpload (MultipartFile imagem) throws IOException{
        if (imagem.isEmpty()){
            System.out.println("imagem vazia");
            return null;
        }

        String[] nomeArquivoArray = imagem.getOriginalFilename().split("\\.");
        String novoNome = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"));
        String extencaoArquivo = nomeArquivoArray[nomeArquivoArray.length - 1];

        String nomeImg = novoNome + "." + extencaoArquivo;

        File imagemCriada = new File(diretorioImg + "\\" + nomeImg);

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(imagemCriada));

        stream.write(imagem.getBytes());
        stream.close();

        return nomeImg;
    }
}
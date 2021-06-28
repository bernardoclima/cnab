package com.example.remessa_cnab;

import com.example.remessa_cnab.citi.cobranca.modelo400.dto.DetalheCiti;
import com.example.remessa_cnab.citi.cobranca.modelo400.dto.HeaderArquivoCiti;
import com.example.remessa_cnab.citi.cobranca.modelo400.dto.TraillerArquivoCiti;
import com.example.remessa_cnab.framework.gerador.builders.Formato400BuilderCnab;
import com.example.remessa_cnab.framework.gerador.gerenciador.Cnab;
import com.example.remessa_cnab.framework.gerador.gerenciador.GerenciadorCnab;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootApplication
public class RemessaCnabApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemessaCnabApplication.class, args);
    }

}

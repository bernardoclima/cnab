package com.example.remessa_cnab.citi.executor;

import com.example.remessa_cnab.citi.cobranca.modelo400.dto.DetalheCiti;
import com.example.remessa_cnab.citi.cobranca.modelo400.dto.HeaderArquivoCiti;
import com.example.remessa_cnab.citi.cobranca.modelo400.dto.TraillerArquivoCiti;
import com.example.remessa_cnab.framework.gerador.builders.Formato400BuilderCnab;
import com.example.remessa_cnab.framework.gerador.gerenciador.Cnab;
import com.example.remessa_cnab.framework.gerador.gerenciador.GerenciadorCnab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
@Order(1)
public class TesteGeracaoArquivoRemessa implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(TesteGeracaoArquivoRemessa.class);

    @Override
    public void run(String... args) throws Exception {
        Cnab cnab = new Cnab();
        cnab.adicionarRegistro(new HeaderArquivoCiti("CONSULTORIA DE CREDITO","1111212211"));
        cnab.adicionarRegistro(new DetalheCiti("81698032000104","1111212211",2,000000000036,"000000000036",1));
        cnab.adicionarRegistro(new TraillerArquivoCiti(4));
        GerenciadorCnab gerenciadorCnab = new GerenciadorCnab();
        gerenciadorCnab.contruirCnabRemessaCiti(new Formato400BuilderCnab(cnab));
        gerenciadorCnab.imprimiRemessa();
        String strDt = new SimpleDateFormat("yyyyMMddhhmmss").format(Calendar.getInstance().getTime());
        gerenciadorCnab.gerarArquivo("Teste_rem_Cob_EMP_0082587047_"+strDt,".rem","C:"+ File.separator+"TEMP"+File.separator+"REMESSAS");

    }
}

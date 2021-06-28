package com.example.remessa_cnab.framework.gerador.gerenciador;

import com.example.remessa_cnab.conexao.sftp.FileTransferServiceImpl;
import com.example.remessa_cnab.framework.gerador.RetornoCnab;
import com.example.remessa_cnab.framework.gerador.builders.Formato400BuilderCnab;
import com.example.remessa_cnab.framework.gerador.RemessaCnab;
import com.example.remessa_cnab.framework.gerador.builders.BuilderCnab;
import com.example.remessa_cnab.framework.gerador.builders.Formato240BuilderCnab;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Getter
@Setter
@NoArgsConstructor
public class GerenciadorCnab {
    private Logger logger = LoggerFactory.getLogger(FileTransferServiceImpl.class);

   private BuilderCnab builderCnab;
    public void contruirCnabRemessaCiti(Formato400BuilderCnab builder) {
        builderCnab=builder;
    }

    public void contruirCnabRemessaFebraban(Formato240BuilderCnab builder) {
        builderCnab=builder;
    }

    public RemessaCnab obtemRemessa(){
        return builderCnab.obtemRemessa();
    }

    public RetornoCnab obtemRetorno(){
        return builderCnab.obtemRetorno();
    }

    public void imprimiRemessa(){
         builderCnab.obtemRemessa().imprimi();
    }

    public void gerarArquivo(String prefixo, String sufixo,String localizacao){

        try {
            File folder = new File(localizacao);
            if(!folder.exists())
                folder.mkdirs();
            FileWriter fileWriter = new FileWriter(new File(localizacao+File.separator+prefixo+sufixo));
            BufferedWriter bwr = new BufferedWriter(fileWriter);
            bwr.write(obtemRemessa().gerarLinhas());
            bwr.flush();
            bwr.close();
            System.out.println("Arquivo gerado "+localizacao+"->"+prefixo+sufixo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.remessa_cnab.framework.gerador.builders;

import com.example.remessa_cnab.framework.gerador.RemessaCnab;
import com.example.remessa_cnab.framework.gerador.RetornoCnab;
import com.example.remessa_cnab.framework.gerador.template.Lote;
import com.example.remessa_cnab.framework.gerador.template.RodapeArquivo;
import com.example.remessa_cnab.framework.gerador.template.CabecalhoArquivo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Formato240BuilderCnab implements BuilderCnab{
    private CabecalhoArquivo cabecalhoArquivo;
    private List<Lote> lotes;
    private RodapeArquivo rodapeArquivo;


    @Override
    public RemessaCnab obtemRemessa(){
        StringBuffer arquivoSB = new StringBuffer();
        arquivoSB.append(cabecalhoArquivo.gerarLinha());
        lotes.stream().forEach(d->arquivoSB.append(d.gerarLinha()));
        arquivoSB.append(rodapeArquivo.gerarLinha());
        return new RemessaCnab(arquivoSB);

    }

    @Override
    public RetornoCnab obtemRetorno() {
        return null;
    }

    public void validar(){


    }

}

package com.example.remessa_cnab.framework.gerador.builders;

import com.example.remessa_cnab.framework.gerador.RetornoCnab;
import com.example.remessa_cnab.framework.gerador.gerenciador.Cnab;
import com.example.remessa_cnab.framework.gerador.template.Detalhe;
import com.example.remessa_cnab.framework.gerador.template.RodapeArquivo;
import com.example.remessa_cnab.framework.gerador.RemessaCnab;
import com.example.remessa_cnab.framework.gerador.template.CabecalhoArquivo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Formato400BuilderCnab implements BuilderCnab{
    private CabecalhoArquivo cabecalhoArquivo;
    private List<Detalhe> detalhes;
    private RodapeArquivo rodapeArquivo;

    private Cnab cnab;

    public Formato400BuilderCnab(Cnab cnab){
        this.cnab=cnab;
    }

    public RemessaCnab obtemRemessa() {
        setCabecalhoArquivo(getCnab().getCabecalhoArquivo());
        setDetalhes(getCnab().getDetalhes());
        setRodapeArquivo(getCnab().getRodapeArquivo());
        StringBuffer arquivoSB = new StringBuffer();
        if (!Objects.isNull(getCabecalhoArquivo()))
            arquivoSB.append(getCabecalhoArquivo().gerarLinha());

        if (!Objects.isNull(getDetalhes()))
            getDetalhes().stream().forEach(d->arquivoSB.append(d.gerarLinha()));

        if (!Objects.isNull(getRodapeArquivo()))
            arquivoSB.append(getRodapeArquivo().gerarLinha());


        return new RemessaCnab(arquivoSB);
    }

    @Override
    public RetornoCnab obtemRetorno() {
        return null;
    }

    @Override
    public void validar(){


    }



}

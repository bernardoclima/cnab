package com.example.remessa_cnab.framework.gerador.template;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Lote {

    private CabecalhoLote cabecalhoLote;
    private List<CabecalhoLote> cabecalhoIniciasLote;
    private List<Detalhe> detalhes;
    private List<RodapeLote> rodapeFinaisLote;
    private RodapeLote rodapeLote;



    public String gerarLinha() {
        StringBuffer arquivoSB = new StringBuffer();
        arquivoSB.append(getCabecalhoLote().gerarLinha());
        getCabecalhoIniciasLote().stream().forEach(d->arquivoSB.append(d.gerarLinha()));
        getDetalhes().stream().forEach(d->arquivoSB.append(d.gerarLinha()));
        getRodapeFinaisLote().stream().forEach(d->arquivoSB.append(d.gerarLinha()));
        arquivoSB.append(getRodapeLote().gerarLinha());
        return arquivoSB.toString();
    }


    public void imprimiLinha() {
        getCabecalhoLote().imprimiLinha();
        getCabecalhoIniciasLote().stream().forEach(CabecalhoLote::imprimiLinha);
        getDetalhes().stream().forEach(Detalhe::imprimiLinha);
        getRodapeFinaisLote().stream().forEach(RodapeLote::imprimiLinha);
        getRodapeLote().imprimiLinha();
    }
}

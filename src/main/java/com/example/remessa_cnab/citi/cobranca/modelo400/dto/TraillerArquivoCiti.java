package com.example.remessa_cnab.citi.cobranca.modelo400.dto;

import com.example.remessa_cnab.framework.gerador.annotations.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Trailller
@Getter
@Setter
@NoArgsConstructor
public class TraillerArquivoCiti {

    @Posicao(ini = 1,tam = 1,descricao = "Identificação do registro")
    @Numerico
    @ValorPadrao("9")
    private Integer identificacaoRegistro;

    @Posicao(ini = 2,tam = 393,descricao = "Filler")
    @Brancos
    private String brancos;

    @Posicao(ini = 395,tam = 6,descricao = "Sequência do registro do arquivo remessa")
    @Numerico
    @Sequencial
    private Integer sequencial;

    public TraillerArquivoCiti(Integer sequencial){
        this.sequencial=sequencial;
    }
}

package com.example.remessa_cnab.citi.cobranca.modelo400.dto;

import com.example.remessa_cnab.framework.gerador.annotations.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Header
@Getter
@Setter
@NoArgsConstructor
public class HeaderArquivoCiti{

    @Posicao(ini = 1,tam = 1,descricao = "Identificação do registro")
    @Numerico
    @ValorPadrao("0")
    private Integer identificacaoRegistro;

    @Posicao(ini = 2,tam = 1,descricao = "Identificação do Arquivo")
    @Numerico
    @ValorPadrao("1")
    private Integer identificacaoArquivo;

    @Posicao(ini = 3,tam = 7)
    @Alfanumerico
    @ValorPadrao("REMESSA")
    private String identificacaoArquivoPorExtenso;

    @Posicao(ini = 10,tam = 2,descricao = "Identificacao Tipo Servico")
    @Numerico
    @ValorPadrao("1")
    private Integer identificacaoTipoServico;

    @Posicao(ini = 12,tam = 15,descricao = "Identificacao Tipo Servico Por Extenso")
    @Alfanumerico
    @ValorPadrao("COBRANCA")
    private String identificacaoTipoServicoPorExtenso;

    @Posicao(ini = 27,tam = 20,descricao = "Id. da empresa no Citibank ")
    @Alfanumerico
    private String IdDaEmpresaNoCitibank ;

    @Posicao(ini = 47,tam = 30,descricao = "Id. da empresa no Citibank ")
    @Alfanumerico
    private String nomeEmpresa ;

    @Posicao(ini = 77,tam = 3,descricao = "Número do Citibank na compensação")
    @Numerico
    @ValorPadrao("745")
    private Integer bancoCompensacao;

    @Posicao(ini = 80,tam = 15,descricao = "Nome Banco")
    @Numerico
    @ValorPadrao("CITIBANK")
    private String nomeBanco;

    @Posicao(ini = 77,tam = 3,descricao = "Número do Citibank na compensação")
    @Date
    private Date dataGravacaoArquivo;

    @Posicao(ini = 101,tam = 5,descricao = "Densidade de gravação")
    @Alfanumerico
    @ValorPadrao("01600")
    private String desidadeGravacao;

    @Posicao(ini = 106,tam = 3,descricao = "Unidade de densidade de gravação")
    @Alfanumerico
    @ValorPadrao("BPI")
    private String unidadeDensidadeGravacao;

    @Posicao(ini = 109,tam = 6,descricao = "Unidade volume fisico")
    @Alfanumerico
    private String unidadeVolumeFisico;

    @Posicao(ini = 115,tam = 180,descricao = "Identificador de impressão")
    @Alfanumerico
    private String idImpressao;

    @Posicao(ini = 395,tam = 6,descricao = "Sequência do registro do arquivo remessa")
    @Numerico
    @Sequencial
    private Integer sequencial;

    public HeaderArquivoCiti(String nomeEmpresa, String convenio){
        this.IdDaEmpresaNoCitibank=convenio;
        this.nomeEmpresa=nomeEmpresa;
    }
}

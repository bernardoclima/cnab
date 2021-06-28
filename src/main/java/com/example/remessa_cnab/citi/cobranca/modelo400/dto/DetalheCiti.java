package com.example.remessa_cnab.citi.cobranca.modelo400.dto;

import com.example.remessa_cnab.framework.gerador.annotations.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Details
@Getter
@Setter
public class DetalheCiti {
    @Posicao(ini = 1,tam = 1,descricao = "Identificação do registro")
    @Numerico
    @ValorPadrao("1")
    private Integer identificacaoRegistro;

    @Posicao(ini = 2,tam = 2,descricao = "Identificação do tipo de inscrição da empresa")
    @Numerico
    private Integer identificacaoTipoEmpresa;

    @Posicao(ini = 4,tam = 14,descricao = "Identificação do tipo de inscrição da empresa - GOOGLE")
    @Numerico
    private String numeroInscricaiEmpresa;

    @Posicao(ini = 18,tam = 20,descricao = "Id. da empresa no Citibank ")
    @Alfanumerico
    private String IdDaEmpresaNoCitibank ;

    @Posicao(ini = 38,tam = 25,descricao = "Id. titulo na empresa ")
    @Alfanumerico
    private String IdTituloEmpresa ;

    @Posicao(ini = 63,tam = 2,descricao = "Especie de Titulo")
    @Numerico
    @ValorPadrao("0")
    private Integer especie;

    @Posicao(ini = 65,tam = 12,descricao = "Nosso Numero")
    @Numerico
    private Integer nossoNUmero ;

    @Posicao(ini = 77,tam = 5,descricao = "Filler")
    @Brancos
    private String brancos1;

    @Posicao(ini = 108,tam = 1,descricao = "Codigo Carteira - Cobrança Simples")
    @Numerico
    @ValorPadrao("1")
    private Integer codigoCarteira;

    @Posicao(ini = 109,tam = 2,descricao = "Codigo da Ocorrencia - 02 Pedido de baixa")
    @Numerico
    @ValorPadrao("2")
    private Integer codigoOcorrencia;

    @Posicao(ini = 111,tam = 10,descricao = "Seu Numero")
    @Alfanumerico
    private String seuNUmero ;

    @Posicao(ini = 121,tam = 6,descricao = "Vencimento")
    @Date
    @ValorPadrao("0")
    private Date vencimento ;

    @Posicao(ini = 127,tam = 11,descricao = "Valor Nominal do Titulo")
    @Numerico
    @ValorPadrao("0")
    private BigDecimal valoNominal ;

    @Posicao(ini = 140,tam = 3,descricao = "Número do Citibank na compensação")
    @Numerico
    @ValorPadrao("745")
    private Integer bancoCompensacao;

    @Posicao(ini = 143,tam = 5,descricao = "Uso Exclusivo do Banco")
    @Numerico
    @ValorPadrao("0")
    private String exclusivoBano ;

    @Posicao(ini = 148,tam = 2,descricao = "Tipo Emissão")
    @Numerico
    @ValorPadrao("0")
    private Integer tipoEmissao ;

    @Posicao(ini = 150,tam = 1,descricao = "Aceite")
    @Alfanumerico
    private String aceite ;

    @Posicao(ini = 157,tam = 2,descricao = "Data Emissão de Titulos")
    @Date
    @ValorPadrao("0")
    private Date dataEmissaoTitulo ;

    @Posicao(ini = 157,tam = 2,descricao = "Numer de Dias Validados pra instrução")
    @Numerico
    @ValorPadrao("0")
    private BigDecimal instrucaoTitulo ;

    @Posicao(ini = 159,tam = 2,descricao = "Numer de Dias Validados pra instrução")
    @Numerico
    @ValorPadrao("0")
    private Integer numDiasInstrucao ;

    @Posicao(ini = 161,tam = 11,descricao = "Mora")
    @Numerico
    @ValorPadrao("0")
    private BigDecimal juros ;

    @Posicao(ini = 174,tam = 2,descricao = "Data Limite Desconto")
    @Numerico
    @ValorPadrao("0")
    private BigDecimal dataLimiteDesconto ;

    @Posicao(ini = 180,tam = 2,descricao = "Valor Desconto")
    @Numerico
    @ValorPadrao("0")
    private BigDecimal valorDesconto ;

    @Posicao(ini = 193,tam = 4,descricao = "F")
    @Brancos
    private String filler ;

    @Posicao(ini = 197,tam = 2,descricao = "Valor IOF")
    @Numerico
    @ValorPadrao("0")
    private BigDecimal valorIOf ;

    @Posicao(ini = 206,tam = 11,descricao = "Valor Abatimento")
    @Numerico
    @ValorPadrao("0")
    private BigDecimal valorAbatimento ;

    @Posicao(ini = 219,tam = 2,descricao = "Tipo Numero Sacado")
    @Numerico
    @ValorPadrao("1")
    private String tipoInscriçãoSacado ;

    @Posicao(ini = 221,tam = 14,descricao = "Numero Sacado")
    @Numerico
    @ValorPadrao("0")
    private String numeroInscriçãoSacado ;

    @Posicao(ini = 327,tam = 8,descricao = "Seu Numero")
    @Numerico
    @ValorPadrao("0")
    private String cep ;

    @Posicao(ini = 392,tam = 2,descricao = "Filler")
    @Brancos
    private String brancos;

    @Posicao(ini = 394,tam = 1,descricao = "Codigo da Moeda")
    @Numerico
    @ValorPadrao("9")
    private Integer codigoMoeda;


    @Posicao(ini = 395,tam = 6,descricao = "Sequência do registro do arquivo remessa")
    @Numerico
    @Sequencial
    private Integer sequencial;

    public DetalheCiti(String cnpj, String convenio, Integer codigoOcorrencia, Integer nossoNUmero, String seuNUmero,Integer sequencial){
        this.IdDaEmpresaNoCitibank=convenio;
        this.numeroInscricaiEmpresa=cnpj;
        this.sequencial=sequencial;
        this.codigoOcorrencia=codigoOcorrencia;
        this.nossoNUmero=nossoNUmero;
        this.seuNUmero=seuNUmero;
        this.identificacaoTipoEmpresa=cnpj.length()>11?2:1;
    }
}

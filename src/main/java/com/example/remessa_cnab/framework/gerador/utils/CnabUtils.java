package com.example.remessa_cnab.framework.gerador.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class CnabUtils {

    public static String PAD_ZERO="0";
    public static String PAD_BRANCO=" ";
    public static String QUEBRA_LINHA="\n";
    public static String FORMAT_DATE_SIMPLES="ddMMyy";
    public static String FORMAT_DATE_SIMPLES_ANO_COMPETO="ddMMyyyy";
    public static String FORMAT_DATE_TEMPO="hhmmss";

    public static String preencheEsquerda(String str,int tamanho, String padStr){
        return StringUtils.leftPad(str, tamanho, padStr);
    }

    public static void preencheDireta(String str,int tamanho, String padStr){
        str= StringUtils.rightPad(str, tamanho, padStr);
    }

    public static String linhaEmBrancoComQuebraLinha(String str,int tamanho,String padStr,String finalLinha){
        str= preencheEsquerda(str, tamanho, padStr);
        if(!Objects.isNull(finalLinha))
            str=str+finalLinha;
        return str;
    }

    public static String linhaEmBrancoComQuebraLinha(String str,int tamanho,String padStr){
        return linhaEmBrancoComQuebraLinha(str, tamanho, padStr,QUEBRA_LINHA);
    }
    public static String linhaEmBrancoComQuebraLinha(String str,int tamanho){
        return linhaEmBrancoComQuebraLinha(str, tamanho, PAD_BRANCO);
    }
    public static String linhaEmBrancoComQuebraLinha(int tamanho){
        return linhaEmBrancoComQuebraLinha("", tamanho, PAD_BRANCO);
    }

    public static String linhaEmBranco(String str,int tamanho,String padStr){
        return linhaEmBrancoComQuebraLinha(str, tamanho, padStr,null);
    }
    public static String linhaEmBranco(String str,int tamanho){
        return linhaEmBranco(str, tamanho, "");
    }

    public static String preenchebranco(String str,int tamanho){
        return preencheEsquerda(str, tamanho,PAD_BRANCO);
    }

    public static String preencheNumerico(String str,int tamanho){
         return preencheEsquerda(str,tamanho,PAD_ZERO);
    }
    public static String preencheNumerico(BigDecimal numero, int tamanho){
        return preencheNumerico(numero.toString(),tamanho);
    }

    public static String preencheNumerico(Integer numero, int tamanho){
        return preencheNumerico(numero.toString(),tamanho);
    }

    public static String preencheAlfaNumerico(String str,int tamanho){
        return preencheEsquerda(str,tamanho,PAD_BRANCO);
    }

    public static String preencheAlfaNumerico(Integer numero, int tamanho){
        return preencheAlfaNumerico(numero.toString(),tamanho);
    }

    public static String preencheDate(String str,int tamanho){
        return preencheEsquerda(str,tamanho,PAD_ZERO);
    }

    public static String preencheDate(Date date, int tamanho){
        String str = "";
        DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE_SIMPLES);
        if (!Objects.isNull(date))
            str=dateFormat.format(date);
        return preencheEsquerda(str,tamanho,PAD_ZERO);
    }
    public static String preencheDate(Calendar calendar, int tamanho){
        String str = "";
        Date date = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE_SIMPLES);
        if (!Objects.isNull(date))
            str=dateFormat.format(date);
        return preencheEsquerda(str,tamanho,PAD_ZERO);
    }



}

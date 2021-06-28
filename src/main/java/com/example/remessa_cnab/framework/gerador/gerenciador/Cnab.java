package com.example.remessa_cnab.framework.gerador.gerenciador;

import com.example.remessa_cnab.framework.gerador.annotations.*;
import com.example.remessa_cnab.framework.gerador.template.CabecalhoArquivo;
import com.example.remessa_cnab.framework.gerador.template.Detalhe;
import com.example.remessa_cnab.framework.gerador.template.Lote;
import com.example.remessa_cnab.framework.gerador.template.RodapeArquivo;
import com.example.remessa_cnab.framework.gerador.utils.CnabUtils;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Cnab {
    private String registro="";
    private List list = new ArrayList();
    private List detalhes = new ArrayList();
    private List lotes = new ArrayList();
    private CabecalhoArquivo cabecalhoArquivo;
    private RodapeArquivo rodapeArquivo;

    public <T> void adicionarRegistro(T objeto){
        list.add(objeto);
        parse(objeto);
    }
    public void limparListaRegistro(){
        list=new ArrayList();
    }

    public CabecalhoArquivo getCabecalhoArquivo(){
        return cabecalhoArquivo;
    }
    public RodapeArquivo getRodapeArquivo(){
        return rodapeArquivo;
    }
    public List<Detalhe> getDetalhes(){
        return detalhes;
    }

    public void addDetalhe(Detalhe detalhe){
        detalhes.add(detalhe);
    }
    public List<Lote> getLotes(){
        return detalhes;
    }

    public void addLote(Lote lote){
        lotes.add(lote);
    }

    private <T> void parse(T objeto) {
        registro="";
        Class<?> classe = objeto.getClass();
        if (classe.isAnnotationPresent(Header.class)){
            parseToHeader(objeto);
            cabecalhoArquivo = new CabecalhoArquivo(parseToLinha(objeto));
        }else
        if (classe.isAnnotationPresent(HeaderLote.class)){
            parseToHeaderLote(objeto);
        }else
        if (classe.isAnnotationPresent(HeaderIniciaisLote.class)){
            parseToHeaderIniciaisLote(objeto);
        }else
        if (classe.isAnnotationPresent(Details.class)){
            parseToDetails(objeto);
            addDetalhe(new Detalhe(parseToLinha(objeto)));
        }else
        if (classe.isAnnotationPresent(Segment.class)){
            parseToSegment(objeto);
        }else
        if (classe.isAnnotationPresent(TrailllerFinaisLote.class)){
            parseToTrailllerFinaisLote(objeto);
        }else
        if (classe.isAnnotationPresent(TrailllerLote.class)){
            parseToTrailllerLote(objeto);
        }else
        if (classe.isAnnotationPresent(Trailller.class)){
            parseToTrailller(objeto);
            rodapeArquivo = new RodapeArquivo(parseToLinha(objeto));
        }

    }
    private <T> void parseToHeader(T objeto) {
        Class<?> classe = objeto.getClass();
        Header header = classe.getAnnotation(Header.class);
        registro= CnabUtils.linhaEmBrancoComQuebraLinha(header.tam());
    }

    private <T> void parseToHeaderLote(T objeto) {
        Class<?> classe = objeto.getClass();
        HeaderLote headerLote = classe.getAnnotation(HeaderLote.class);
        registro= CnabUtils.linhaEmBrancoComQuebraLinha(headerLote.tam());
    }

    private <T> void parseToHeaderIniciaisLote(T objeto) {
        Class<?> classe = objeto.getClass();
        HeaderIniciaisLote headerIniciaisLote = classe.getAnnotation(HeaderIniciaisLote.class);
        registro= CnabUtils.linhaEmBrancoComQuebraLinha(headerIniciaisLote.tam());
    }

    private <T> void parseToDetails(T objeto) {
        Class<?> classe = objeto.getClass();
        Details details = classe.getAnnotation(Details.class);
        registro= CnabUtils.linhaEmBrancoComQuebraLinha(details.tam());
    }

    private <T> void parseToSegment(T objeto) {
        Class<?> classe = objeto.getClass();
        Segment segment = classe.getAnnotation(Segment.class);
        registro= CnabUtils.linhaEmBrancoComQuebraLinha(segment.tam());
    }

    private <T> void parseToTrailllerFinaisLote(T objeto) {
        Class<?> classe = objeto.getClass();
        TrailllerFinaisLote trailllerFinaisLote = classe.getAnnotation(TrailllerFinaisLote.class);
        registro= CnabUtils.linhaEmBrancoComQuebraLinha(trailllerFinaisLote.tam());
    }

    private <T> void parseToTrailllerLote(T objeto) {
        Class<?> classe = objeto.getClass();
        TrailllerLote trailllerLote = classe.getAnnotation(TrailllerLote.class);
        registro= CnabUtils.linhaEmBrancoComQuebraLinha(trailllerLote.tam());
    }
    private <T> void parseToTrailller(T objeto) {
        Class<?> classe = objeto.getClass();
        Trailller trailller = classe.getAnnotation(Trailller.class);
        registro= CnabUtils.linhaEmBrancoComQuebraLinha(trailller.tam());
    }

    public <T> String parseToLinha(T objeto) {

        Class<?> classe = objeto.getClass();
        for (Field field: classe.getDeclaredFields()){
            if(field.isAnnotationPresent(Posicao.class)){
                Posicao posicao = field.getAnnotation(Posicao.class);
                StringBuilder s = new StringBuilder(registro);
                Boolean isAlfa= true;
                Boolean isNum,isDate,isSequencial=false;
                String valor = "";

                Object obj = getProperty(objeto,field.getName());
                valor= !Objects.isNull(obj)?obj.toString():"";

                if(field.isAnnotationPresent(ValorPadrao.class)){
                    ValorPadrao valorPadrao = field.getAnnotation(ValorPadrao.class);
                    valor = valorPadrao.value();
                }
                if(field.isAnnotationPresent(Brancos.class)){
                    valor= CnabUtils.preenchebranco(valor,posicao.tam());
                }else
                if(field.isAnnotationPresent(Alfanumerico.class)){
                    valor= CnabUtils.preencheAlfaNumerico(valor,posicao.tam());
                    isAlfa=true;
                    isNum=false;
                    isDate=false;
                }else if(field.isAnnotationPresent(Numerico.class)){
                    valor= CnabUtils.preencheNumerico(valor,posicao.tam());
                    isAlfa=false;
                    isNum=true;
                    isDate=false;
                }else if(field.isAnnotationPresent(Date.class)){
                    valor= CnabUtils.preencheDate(valor,posicao.tam());
                    isAlfa=false;
                    isNum=false;
                    isDate=true;
                }
                if(field.isAnnotationPresent(Sequencial.class)){
                    isSequencial=true;
                }
                registro=s.replace(posicao.ini()-1,posicao.ini()-1+posicao.tam(),valor).toString();


            }
        }
        return registro;
    }

    public static Object getProperty(Object obj, String property) {
        Object returnValue = null;

        try {
            String methodName = "get" + property.substring(0, 1).toUpperCase() + property.substring(1, property.length());
            Class clazz = obj.getClass();
            Method method = clazz.getMethod(methodName, null);
            returnValue = method.invoke(obj, null);
        }
        catch (Exception e) {}

        return returnValue;
    }
}

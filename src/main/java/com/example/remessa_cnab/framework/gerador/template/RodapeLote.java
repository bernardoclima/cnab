package com.example.remessa_cnab.framework.gerador.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RodapeLote implements Registro {

    private String linha;

    @Override
    public String gerarLinha() {
        return linha;
    }

    @Override
    public void imprimiLinha() {
        System.out.println(linha);
    }
}

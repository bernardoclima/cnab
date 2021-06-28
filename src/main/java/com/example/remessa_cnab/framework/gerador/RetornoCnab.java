package com.example.remessa_cnab.framework.gerador;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RetornoCnab {
    private StringBuffer linhas;

    public void imprimi() {
      System.out.println(ler());
    }

    public String ler() {
        return linhas.toString();
    }

}

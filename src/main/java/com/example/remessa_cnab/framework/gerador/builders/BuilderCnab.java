package com.example.remessa_cnab.framework.gerador.builders;

import com.example.remessa_cnab.framework.gerador.RemessaCnab;
import com.example.remessa_cnab.framework.gerador.RetornoCnab;

public interface BuilderCnab {

    public RemessaCnab obtemRemessa();
    public RetornoCnab obtemRetorno();
    public void validar();
    
}

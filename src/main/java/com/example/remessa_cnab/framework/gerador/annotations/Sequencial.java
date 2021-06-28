package com.example.remessa_cnab.framework.gerador.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Sequencial {
    int init() default 0;
    String grupo() default "Arquivo";
}

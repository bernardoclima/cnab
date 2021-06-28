package com.example.remessa_cnab.framework.gerador.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface HeaderIniciaisLote {
    int tam() default 400;
}

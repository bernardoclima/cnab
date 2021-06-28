package com.example.remessa_cnab.framework.gerador.annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Posicao {
    int ini();
    int tam() default 1;
    int fim() default 0;
    String descricao() default "";

}

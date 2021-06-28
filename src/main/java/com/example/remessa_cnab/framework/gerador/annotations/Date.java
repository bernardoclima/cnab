package com.example.remessa_cnab.framework.gerador.annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Date {
    String format() default "DDMMAA";
}

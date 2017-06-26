package com.cmrevoredo.s2d2.modeling.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SensitiveData{
	String encrypt() default "";
	boolean setNullIfRead() default false;
}

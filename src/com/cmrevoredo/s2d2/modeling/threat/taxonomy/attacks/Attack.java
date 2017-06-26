package com.cmrevoredo.s2d2.modeling.threat.taxonomy.attacks;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.cmrevoredo.s2d2.modeling.threat.taxonomy.vectors.AttackVectors;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Attack {
	String name();
	AttackVectors vector();
}

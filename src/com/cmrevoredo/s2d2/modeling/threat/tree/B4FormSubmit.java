package com.cmrevoredo.s2d2.modeling.threat.tree;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.cmrevoredo.s2d2.modeling.threat.taxonomy.vectors.AttackVectors;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface B4FormSubmit {
	AttackVectors [] vectors();
}

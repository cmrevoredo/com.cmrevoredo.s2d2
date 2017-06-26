package com.cmrevoredo.s2d2.modeling.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.SoftException;
import org.aspectj.lang.reflect.FieldSignature;
import org.aspectj.lang.reflect.MethodSignature;

public final class Utils {

	public static <A extends Annotation> A getAnnotationByMethod(JoinPoint joinPoint, Class<A> aType){
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		return signature.getMethod().getAnnotation(aType);
	}

	public static <A extends Annotation> A getAnnotationByField(JoinPoint joinPoint, Class<A> aType){
		FieldSignature signature = (FieldSignature) joinPoint.getSignature();
		return signature.getField().getAnnotation(aType);
	}
	
	public static <T> T getElement(T[] elements, T element){
		for (T t : elements) {
			if (t.equals(element)){
				return t;
			}
		}
		return null;		
	}

	public static Field getField(Signature signature, Object target) {
		try {
			Field field = signature.getDeclaringType().getDeclaredField(signature.getName());
			field.setAccessible(true);
			return field;
		}
		catch (Exception e) { throw new SoftException(e); }
	} 	

}

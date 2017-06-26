package com.cmrevoredo.s2d2.coding.observers;

import org.aspectj.lang.JoinPoint;

import com.cmrevoredo.s2d2.modeling.threat.taxonomy.vectors.AttackVectors;
import com.cmrevoredo.s2d2.modeling.threat.tree.B4FormSubmit;
import com.cmrevoredo.s2d2.modeling.utils.Utils;
import com.cmrevoredo.s2d2.web.protocols.http.act.HttpResponse;
import com.google.gson.JsonObject;

public aspect B4Observer {

	/*
	private pointcut doPostbyHtmlForm(HTMLFormElement form)
	: execution(@B4FormSubmit * *(..)) && args(form);
	*/

	private pointcut doPostbyJsonObject(JsonObject form)
	: execution(@B4FormSubmit * *(..)) && args(form);
	
	private B4FormSubmit getB4FormSubmit(JoinPoint joinPoint){
		return Utils.getAnnotationByMethod(joinPoint, B4FormSubmit.class);
	}
	
	private AttackVectors getVectorElement(AttackVectors[] vectors, AttackVectors vector){
		return Utils.getElement(vectors, vector);
	}
	
	/*	
	before(HTMLFormElement form) : doPostbyHtmlForm(form) {
		System.out.println("antes de executar, filtrar os params " + form.getMethod());
	}

	after(HTMLFormElement form) returning (HttpResponse response) : doPostbyHtmlForm(form) {
		System.out.println("método executado " + response.getBody());
	}
	*/

	before(JsonObject jsonObject) : doPostbyJsonObject(jsonObject) {
		B4FormSubmit ann = this.getB4FormSubmit(thisJoinPoint);
		if (getVectorElement(ann.vectors(), AttackVectors.V4)!=null){
			System.out.println("filtrando XSS " + jsonObject.get("login") + " no método: " + thisJoinPoint.getSignature());		
		}		
	}

	after(JsonObject jsonObject) returning (HttpResponse response) : doPostbyJsonObject(jsonObject) {
		System.out.println(thisJoinPoint.getSignature() + " executado com resultado: " + response.getBody());
	}
	
}

package com.cmrevoredo.s2d2.exemplo;

import com.cmrevoredo.s2d2.modeling.threat.taxonomy.vectors.AttackVectors;
import com.cmrevoredo.s2d2.modeling.threat.tree.B4FormSubmit;
import com.cmrevoredo.s2d2.web.protocols.http.act.HttpResponse;
import com.google.gson.JsonObject;

class FormSubmitExample {
	
	public static void main(String[] args) {

		FormSubmitExample html = new FormSubmitExample();

		/*
		HtmlForm form = new HtmlForm();
		form.setAction("/cadastrar");
		form.setMethod("POST");
		html.submit(form);
		*/

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("login", "abc");
		jsonObject.addProperty("password", "123");
		
		html.submit(jsonObject);
		
		
	}
	
	/*
	@B4FormSubmit(vectors={AttackVectors.V3, AttackVectors.V4, AttackVectors.V5})
	public HttpResponse submit(HTMLFormElement form){
		HttpResponse response = new HttpResponse();
		response.setBody("Página resultante do formulário submetido");
		return response;
	}
	*/

	@B4FormSubmit(vectors={AttackVectors.V3, AttackVectors.V4, AttackVectors.V5})
	public HttpResponse submit(JsonObject json){
		HttpResponse response = new HttpResponse();
		response.setBody("Página resultante do json submetido");
		
		AnyEntity any = new AnyEntity();
		any.setLogin(json.get("login").toString());
		any.setPassword(json.get("password").toString());
		
		System.out.println(any.getLogin());
		System.out.println(any.getPassword());
		
		return response;
	}
}

package com.cmrevoredo.s2d2.coding.observers;

public aspect XSSObserver {

	/*
	private pointcut doPostFiltrarXSS(HtmlForm form)
	: execution(@XSS * *(..)) && args(form);
	
	before(HtmlForm form) : doPostFiltrarXSS(form) {
		System.out.println("antes de executar, filtrar os params " + form.getMethod());
	}

	after() returning (HttpResponse response) : execution(@XSS * *(..)) {
		System.out.println("método executado " + response.getBody());
	}

	before(HttpRequest request, HttpHeaders headers, HtmlForm form) : doPost(request, headers, form) {
		try{
		}catch(Exception e){
		}
	}

	after(HttpRequest request, HttpHeaders headers, HtmlForm form) returning(HttpResponse response) : doPost(request, headers, form) {
		try{
		}catch(Exception e){
		}
	}
	*/

}

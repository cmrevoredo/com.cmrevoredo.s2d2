package com.cmrevoredo.s2d2.coding.observers;

import java.lang.reflect.Field;

import com.cmrevoredo.s2d2.modeling.utils.SensitiveData;
import com.cmrevoredo.s2d2.modeling.utils.Utils;

public aspect SensitiveDataObserver {

	private pointcut sensitiveSetter(Object newValue, Object target) :
		set(@SensitiveData * *) && args(newValue) && target(target);

	private pointcut sensitiveGetter(Object target) :
		get(@SensitiveData * *) && target(target);
	
	before(Object newValue, Object target) : sensitiveSetter(newValue, target) {
		Field f = Utils.getField(thisJoinPoint.getSignature(), target);
		Object actualValue = null;
		try{
			actualValue = f.get(target);
		}catch(Exception e){
		}
		System.out.println("Modificando valor (set) de um atributo sensível... " + target.getClass().getSimpleName() + "." + f.getName() + ": " + actualValue + " -> " + newValue);
	}

	before(Object target) : sensitiveGetter(target) {
		System.out.println("Tentando obter valor (get) de um atributo sensível... verificando se é protegido...");
		SensitiveData s = Utils.getAnnotationByField(thisJoinPoint, SensitiveData.class);
		if (s.setNullIfRead()){
			Field f = Utils.getField(thisJoinPoint.getSignature(), target);
			System.out.println("O atributo " + target.getClass().getSimpleName() + "." + f.getName() + " é protegido... O valor não será revelado.");
			try{
				f.set(target, null);
			}catch(Exception e){
			}
		}else{
			System.out.println("O atributo não protegido... O valor será revelado.");
		}		
	}

}

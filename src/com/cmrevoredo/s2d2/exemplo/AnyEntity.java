package com.cmrevoredo.s2d2.exemplo;

import com.cmrevoredo.s2d2.modeling.utils.SensitiveData;

class AnyEntity {
	private String login;
	@SensitiveData(setNullIfRead=true)
	private String password;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

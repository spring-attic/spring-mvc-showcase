package org.springframework.samples.mvc.views;

import javax.validation.constraints.NotNull;

public class JavaBean {
	
	@NotNull
	private String foo;

	@NotNull
	private String fruit;

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

}

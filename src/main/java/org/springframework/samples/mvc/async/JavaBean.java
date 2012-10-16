package org.springframework.samples.mvc.async;

public class JavaBean {

	private String foo;

	private String fruit;

	public JavaBean(String foo, String fruit) {
		this.foo = foo;
		this.fruit = fruit;
	}

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

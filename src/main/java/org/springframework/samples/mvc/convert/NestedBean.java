package org.springframework.samples.mvc.convert;

import java.util.List;
import java.util.Map;

public class NestedBean {
	
	private String foo;

	private List<NestedBean> list;
	
	private Map<String, NestedBean> map;
	
	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}

	public List<NestedBean> getList() {
		return list;
	}

	public void setList(List<NestedBean> list) {
		this.list = list;
	}

	public Map<String, NestedBean> getMap() {
		return map;
	}

	public void setMap(Map<String, NestedBean> map) {
		this.map = map;
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NestedBean");
        if (foo != null) {
        	sb.append(" foo=").append(foo);
        }
        if (list != null) {
        	sb.append(" list=").append(list);
        }
        if (map != null) {
        	sb.append(" map=").append(map);
        }
        return sb.toString();
    }
}
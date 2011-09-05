package org.springframework.samples.mvc.convert;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
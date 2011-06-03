package org.springframework.samples.mvc.convert;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class JavaBean {
	
	private Integer primitive;
	
	@DateTimeFormat(iso=ISO.DATE)
	private Date date;

	@MaskFormat("(###) ###-####")
	private String masked;

	// list will auto-grow as its dereferenced e.g. list[0]=value
	private List<Integer> list;

	// annotation type conversion rule will be applied to each list element
	@DateTimeFormat(iso=ISO.DATE)
	private List<Date> formattedList;

	// map will auto-grow as its dereferenced e.g. map[key]=value
	private Map<Integer, String> map;

	// nested will be set when it is referenced e.g. nested.foo=value
	private NestedBean nested;

    public Integer getPrimitive() {
		return primitive;
	}

	public void setPrimitive(Integer primitive) {
		this.primitive = primitive;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMasked() {
		return masked;
	}

	public void setMasked(String masked) {
		this.masked = masked;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public List<Date> getFormattedList() {
		return formattedList;
	}

	public void setFormattedList(List<Date> formattedList) {
		this.formattedList = formattedList;
	}

	public Map<Integer, String> getMap() {
		return map;
	}

	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}

	public NestedBean getNested() {
		return nested;
	}

	public void setNested(NestedBean nested) {
		this.nested = nested;
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JavaBean");
        if (primitive != null) {
        	sb.append(" primitive=").append(primitive);
        }
        if (date != null) {
            sb.append(" date=").append(date);        	
        }
        if (masked != null) {
        	sb.append(" masked=").append(masked);
        }
        if (list != null) {
            sb.append(" list=").append(list);        	
        }
        if (formattedList != null) {
            sb.append(" formattedList=").append(formattedList);        	
        }
        if (map != null) {
            sb.append(" map=").append(map);       	
        }
        if (nested != null) {        	
            sb.append(" nested=").append(nested);
        }
        return sb.toString();
    }
}

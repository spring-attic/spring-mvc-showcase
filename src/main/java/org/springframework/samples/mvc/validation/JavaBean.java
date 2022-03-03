package org.springframework.samples.mvc.validation;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class JavaBean {
	
	@NotNull
	@Max(5)
	private Integer number;

	@NotNull
	@Future
	@DateTimeFormat(iso=ISO.DATE)
	private Date date;
	
	@Pattern(regexp="/([A-Za-z-0-9])+/g")
	private String alphaNumericHyphen;

	public String getAlphaNumericHyphen() {
		return alphaNumericHyphen;
	}

	public void setAlphaNumericHyphen(String alphaNumericHyphen) {
		this.alphaNumericHyphen = alphaNumericHyphen;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

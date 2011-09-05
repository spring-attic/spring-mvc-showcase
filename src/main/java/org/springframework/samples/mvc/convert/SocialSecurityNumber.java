package org.springframework.samples.mvc.convert;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class SocialSecurityNumber {

	private final String value;
	
	public SocialSecurityNumber(String value) {
		this.value = value;
	}
	
	@MaskFormat("###-##-####")
	public String getValue() {
		return value;
	}

	public static SocialSecurityNumber valueOf(@MaskFormat("###-##-####") String value) {
		return new SocialSecurityNumber(value);
	}

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
package org.springframework.samples.mvc.convert;

import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

public class CustomConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		// register the default formatters in superclass
		super.installFormatters(registry);
		// install my custom ones
		registry.addFormatterForFieldAnnotation(new MaskFormatAnnotationFormatterFactory());
	}

	
}

package com.selfdiagnosis.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

import com.selfdiagnosis.web.EntityToStringConverter;
import com.selfdiagnosis.web.StringToEntityConverterFactory;

@Component(value="applicationConversionService")
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Autowired
	private AdminService adminService;
	
    @Override
    protected void installFormatters(FormatterRegistry registry) {
//        registry.addConverter(new BodyPartConverter(adminService));
//        registry.addConverter(new StringBodyPartConverter());
//        registry.addConverter(new SymptomTypeConverter(adminService));
//        registry.addConverter(new StringSymptomTypeConverter());
        
        registry.addConverter(new EntityToStringConverter());
        registry.addConverterFactory(new StringToEntityConverterFactory(adminService));
        
    }
	
}
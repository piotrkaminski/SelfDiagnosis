package com.selfdiagnosis.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

import com.selfdiagnosis.web.EntityToStringConverter;
import com.selfdiagnosis.web.StringToEntityConverterFactory;

/**
 * Custom conversion service.
 * 
 * @author mmieszkowski
 * 
 */
@Component(value = "applicationConversionService")
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

    /**
     * Injected {@link AdminService}.
     */
    @Autowired
    private AdminService adminService;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.format.support.FormattingConversionServiceFactoryBean
     * #installFormatters(org.springframework.format.FormatterRegistry)
     */
    @Override
    protected void installFormatters(FormatterRegistry registry) {
        registry.addConverter(new EntityToStringConverter());
        registry.addConverterFactory(new StringToEntityConverterFactory(adminService));

    }

}
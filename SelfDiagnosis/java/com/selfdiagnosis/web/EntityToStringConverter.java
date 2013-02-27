package com.selfdiagnosis.web;

import org.springframework.core.convert.converter.Converter;

import com.selfdiagnosis.core.entity.SelfDiagnosisEntity;

/**
 * Converts any entity to String. It uses it's id.
 * 
 * @author mmieszkowski
 *
 */
public class EntityToStringConverter implements Converter<SelfDiagnosisEntity, String> {

    @Override
    public String convert(SelfDiagnosisEntity selfDiagnosisEntity) {
        return selfDiagnosisEntity.toString();
    }

}

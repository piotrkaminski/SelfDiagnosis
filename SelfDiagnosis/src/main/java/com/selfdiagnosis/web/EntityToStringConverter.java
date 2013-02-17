package com.selfdiagnosis.web;

import org.springframework.core.convert.converter.Converter;

import com.selfdiagnosis.core.entity.SelfDiagnosisEntity;

public class EntityToStringConverter implements Converter<SelfDiagnosisEntity, String>{

    @Override
    public String convert(SelfDiagnosisEntity selfDiagnosisEntity) {
        return selfDiagnosisEntity.toString();
    }

}

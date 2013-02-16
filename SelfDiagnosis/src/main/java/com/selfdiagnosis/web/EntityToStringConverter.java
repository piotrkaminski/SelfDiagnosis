package com.selfdiagnosis.web;

import org.springframework.core.convert.converter.Converter;

import com.selfdiagnosis.core.entity.SelfDiagnosisEntity;
import com.selfdiagnosis.core.service.AdminService;

public class EntityToStringConverter implements Converter<SelfDiagnosisEntity, String>{

	public AdminService adminService;

	@Override
	public String convert(SelfDiagnosisEntity selfDiagnosisEntity) {
		return selfDiagnosisEntity.toString();
	}

}

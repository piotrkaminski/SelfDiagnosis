package com.selfdiagnosis.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import com.selfdiagnosis.core.entity.SelfDiagnosisEntity;
import com.selfdiagnosis.core.service.AdminService;

public class StringToEntityConverterFactory implements ConverterFactory<String, SelfDiagnosisEntity>{

	public AdminService adminService;

	public StringToEntityConverterFactory(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@Override
	public <T extends SelfDiagnosisEntity> Converter<String, T> getConverter(Class<T> targetType) {
		return new StringToEntityConverter<T>(targetType);
	}
	
	private final class StringToEntityConverter<T extends SelfDiagnosisEntity> implements Converter<String, T> {

		private Class<T> entityType;
		
		public StringToEntityConverter(Class<T> entityType) {
			this.entityType = entityType;
		}
		
		@Override
		public T convert(String id) {
			return adminService.getEntityByTypeAndId(entityType, Integer.valueOf(id));
		}
		
	}
	

}

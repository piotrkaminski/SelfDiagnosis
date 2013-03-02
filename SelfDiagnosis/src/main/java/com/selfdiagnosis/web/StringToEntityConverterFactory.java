package com.selfdiagnosis.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import com.selfdiagnosis.core.entity.SelfDiagnosisEntity;
import com.selfdiagnosis.core.service.AdminService;

/**
 * Converts string to any entity. We assume that the string represtents entity's
 * id.
 * 
 * @author mmieszkowski
 * 
 */
public class StringToEntityConverterFactory implements ConverterFactory<String, SelfDiagnosisEntity> {

    /**
     * Service needed to extract entity from db.
     */
    private AdminService adminService;

    /**
     * Factory constructor.
     * 
     * @param adminService
     *            service needed in conversion
     */
    public StringToEntityConverterFactory(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public <T extends SelfDiagnosisEntity> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToEntityConverter<T>(targetType);
    }

    /**
     * Universal converter used by factory.
     * 
     * @author mmieszkowski
     * 
     * @param <T>
     *            any entity
     */
    private final class StringToEntityConverter<T extends SelfDiagnosisEntity> implements Converter<String, T> {

        /**
         * Entity type.
         */
        private Class<T> entityType;

        /**
         * Converter's constructor.
         * 
         * @param entityType type to convert to
         */
        public StringToEntityConverter(Class<T> entityType) {
            this.entityType = entityType;
        }

        @Override
        public T convert(String id) {
            return adminService.getEntityByTypeAndId(entityType, Long.valueOf(id));
        }

    }

}

package com.selfdiagnosis.core.entity;

/**
 * Parent class for hibernate entities. It is needed for conversion
 * simplifications.
 * 
 * @author mmieszkowski
 * 
 */
public abstract class SelfDiagnosisEntity {

    public abstract Long getId();

    public String toString() {
        return getId() == null ? null : getId().toString();
    }
}

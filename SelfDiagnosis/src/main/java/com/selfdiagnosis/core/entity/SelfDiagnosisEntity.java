package com.selfdiagnosis.core.entity;

/**
 * Parent class for hibernate entities. It is needed for conversion
 * simplifications.
 * 
 * @author mmieszkowski
 * 
 */
public abstract class SelfDiagnosisEntity {

    /**
     * 
     * @return id as Long if possible
     */
    public abstract Long getId();

    /**
     * Sets id. Used for testing.
     * @param id to set
     */
    public abstract void setId(Long id);
    
    /**
     * String representation of the object. Here it's id.
     * @return id as string
     */
    @Override
    public String toString() {
        if (getId() == null) {
            return null;
        }
        return getId().toString();
    }
}

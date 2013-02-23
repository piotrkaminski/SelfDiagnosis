package com.selfdiagnosis;

/**
 * Constants.
 * 
 * @author mmieszkowski
 * 
 */
public final class SelfDiagnosisConstants {
    
    /**
     * Private constructor to avoid instantiation.
     */
    private SelfDiagnosisConstants() {
        
    }

    /* ENTITITES constants */
    /* Common constants */
    /**
     * Minimum frequency for all entities.
     */
    public static final short ENTITY_FREQUENCY_MIN = 0;

    /**
     * Maximum frequency for all entities.
     */
    public static final short ENTITY_FREQUENCY_MAX = 100;
    
    /* AgeRangeEntity constants */
    /**
     * Minimum age in a range.
     */
    public static final int AGE_RANGE_AGE_MIN = 0;

    /**
     * Maximum age in a range.
     */
    public static final int AGE_RANGE_AGE_MAX = 100;

    /* BodyPartEntity constants */

    /**
     * Body part name maximum length.
     */
    public static final int BODY_PART_NAME_LENGTH_MAX = 50;

    
    /* ContraindicationEntity constants */
    
    /**
     * Contraindication name maximum length.
     */
    public static final int CONTRAINDICATION_NAME_LENGTH_MAX = 50;
    
    
    /* DieaseEntity constants */
    
    /**
     * Disease name maximum length.
     */
    public static final int DISEASE_NAME_LENGTH_MAX = 100;
    
    
    /* DiseaseSymptomEntity constants */
    
    /**
     * Minimum rank value for disease symptom relation.
     */
    public static final short DISEASE_SYMPTOM_RANK_MIN = 0;

    /**
     * Maximum rank value for disease symptom relation.
     */
    public static final short DISEASE_SYMPTOM_RANK_MAX = 10;
    
    
    /* DoctorSpecialtyEntity constants */
    
    /**
     * Doctor specialty name maximum length.
     */
    public static final int DOCTOR_SPECIALTY_NAME_LENGTH_MAX = 100;
    
    
    /* DrugEntity constants */
    
    /**
     * Drug name maximum length.
     */
    public static final int DRUG_NAME_LENGTH_MAX = 50;
    

    /* RecommendationEntity constants */
    
    /**
     * Recommendation maximum length.
     */
    public static final int RECOMMENDATION_LENGTH_MAX = 1000;
    
    
    /* SecurityRoleEntity constants */
    
    /**
     * Security role name maximum length.
     */
    public static final int SECURITY_ROLE_NAME_LENGTH_MAX = 50;


    /* SymptomEntity constants */
    
    /**
     * Symptom name maximum length.
     */
    public static final int SYMPTOM_NAME_LENGTH_MAX = 100;

    
    /* SymptomQuestionAnswerEntity constants */
    
    /**
     * Symptom question answer maximum length.
     */
    public static final int SYMPTOM_QUESTION_ANSWER_LENGTH_MAX = 200;
    
    
    /* SymptomQuestionEntity constants */
    
    /**
     * Symptom question maximum length.
     */
    public static final int SYMPTOM_QUESTION_LENGTH_MAX = 200;


    /* SymptomTypeEntity constants */
    
    /**
     * Symptom type name maximum length.
     */
    public static final int SYMPTOM_TYPE_NAME_LENGTH_MAX = 50;

    
    /* SystemUserEntity constants */
    
    /**
     * System user first name maximum length.
     */
    public static final int SYSTEM_USER_FIRST_NAME_LENGTH_MAX = 50;

    /**
     * System user last name maximum length.
     */
    public static final int SYSTEM_USER_LAST_NAME_LENGTH_MAX = 50;

    /**
     * System user's city name maximum length.
     */
    public static final int SYSTEM_USER_CITY_LENGTH_MAX = 50;
    
    /**
     * System user's password maximum length.
     */
    public static final int SYSTEM_USER_PASSWORD_LENGTH_MAX = 50;


    /**
     * System user's IP maximum length.
     */
    public static final int SYSTEM_USER_IP_LENGTH_MAX = 30;


    /* TestEntity constants */
    
    /**
     * Test name maximum length.
     */
    public static final int TEST_NAME_LENGTH_MAX = 100;


    /* TestFlagEntity constants */
    
    /**
     * Test flag name maximum length.
     */
    public static final int TEST_FLAG_NAME_LENGTH_MAX = 20;

    
    /* TestTypeEntity constants */
    
    /**
     * Test type name maximum length.
     */
    public static final int TEST_TYPE_NAME_LENGTH_MAX = 100;

    
    /* TestUnitEntity constants */
    
    /**
     * Test unit name maximum length.
     */
    public static final int TEST_UNIT_NAME_LENGTH_MAX = 50;

    /**
     * Test unit short name maximum length.
     */
    public static final int TEST_UNIT_SHORT_NAME_LENGTH_MAX = 10;

    
    /* TreatmentEntity constants */
    
    /**
     * Treatment name maximum length.
     */
    public static final int TREATMENT_NAME_LENGTH_MAX = 100;

}

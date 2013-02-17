package com.selfdiagnosis;

/**
 * General exception for Self Diagnosis. All exceptions in application are Runtime Exceptions to avoid
 * unnecessary throws.
 * 
 * @author pkaminski
 *
 */
public class SelfDiagnosisException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public SelfDiagnosisException(String string) {
        super(string);
    }


    public SelfDiagnosisException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelfDiagnosisException(Throwable cause) {
        super(cause);
    }

}

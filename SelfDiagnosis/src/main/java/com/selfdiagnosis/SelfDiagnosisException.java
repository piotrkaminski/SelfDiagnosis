package com.selfdiagnosis;

/**
 * General exception for Self Diagnosis. All exceptions in application are
 * Runtime Exceptions to avoid unnecessary throws.
 * 
 * @author pkaminski
 * 
 */
public class SelfDiagnosisException extends RuntimeException {

    /**
     * Serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * 
     * @param string
     *            exception message
     */
    public SelfDiagnosisException(String string) {
        super(string);
    }

    /**
     * Constructor.
     * 
     * @param message
     *            exception message
     * @param cause
     *            exception cause
     */
    public SelfDiagnosisException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor.
     * 
     * @param cause
     *            exception cause
     */
    public SelfDiagnosisException(Throwable cause) {
        super(cause);
    }

}

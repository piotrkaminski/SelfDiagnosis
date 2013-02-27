package com.selfdiagnosis.core.dao;

import com.selfdiagnosis.SelfDiagnosisException;

/**
 * Exception for issues related with storing data in DAO .
 * 
 * @author siwecki
 *
 */
public class DAOException extends SelfDiagnosisException {

    /**
     * Serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * @param message exception message
     * @param cause exception cause
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor.
     * @param string exception message
     */
    public DAOException(String string) {
        super(string);
    }

    /**
     * Constructor.
     * @param cause exception cause
     */
    public DAOException(Throwable cause) {
        super(cause);
    }

}

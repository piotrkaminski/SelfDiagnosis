package com.selfdiagnosis.core.dao;

import com.selfdiagnosis.SelfDiagnosisException;

/**
 * Exception for issues related with storing data in DAO 
 * 
 * @author siwecki
 *
 */
public class DAOException extends SelfDiagnosisException {

    private static final long serialVersionUID = 1L;

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(String string) {
        super(string);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

}

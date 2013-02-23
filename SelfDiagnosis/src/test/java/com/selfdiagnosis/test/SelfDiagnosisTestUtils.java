package com.selfdiagnosis.test;


/**
 * Utility class with useful test methods.
 * 
 * @author mmieszkowski
 *
 */
public final class SelfDiagnosisTestUtils {

    /**
     * Private constructor to avoid instantiation.
     * 
     */
    private SelfDiagnosisTestUtils() {
        
    }
    /**
     * Generates string with given length.
     * 
     * @param lenght of the string
     * @return dummy string with given length
     */
    public static String generateString(int lenght) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            text.append("a");
        }
        return text.toString();
    }
}

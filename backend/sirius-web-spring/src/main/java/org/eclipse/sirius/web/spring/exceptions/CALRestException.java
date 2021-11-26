package org.eclipse.sirius.web.spring.exceptions;

public class CALRestException extends RuntimeException {
    private static final long serialVersionUID = -7612274852881195495L;

    public CALRestException(String message) {
        super(message);
    }

    public CALRestException(String message, Throwable cause) {
        super(message, cause);
    }
}

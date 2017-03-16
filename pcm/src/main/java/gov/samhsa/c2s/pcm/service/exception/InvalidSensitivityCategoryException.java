package gov.samhsa.c2s.pcm.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidSensitivityCategoryException extends RuntimeException {
    public InvalidSensitivityCategoryException() {
    }

    public InvalidSensitivityCategoryException(String message) {
        super(message);
    }

    public InvalidSensitivityCategoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSensitivityCategoryException(Throwable cause) {
        super(cause);
    }

    public InvalidSensitivityCategoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

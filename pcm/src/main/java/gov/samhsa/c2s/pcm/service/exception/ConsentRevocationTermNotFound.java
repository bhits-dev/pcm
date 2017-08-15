package gov.samhsa.c2s.pcm.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConsentRevocationTermNotFound extends RuntimeException {
    public ConsentRevocationTermNotFound() {
    }

    public ConsentRevocationTermNotFound(String message) {
        super(message);
    }

    public ConsentRevocationTermNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsentRevocationTermNotFound(Throwable cause) {
        super(cause);
    }

    public ConsentRevocationTermNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

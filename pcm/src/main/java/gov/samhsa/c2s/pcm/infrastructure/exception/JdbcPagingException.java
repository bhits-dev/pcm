package gov.samhsa.c2s.pcm.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class JdbcPagingException extends RuntimeException {
    public JdbcPagingException(String message) {
        super(message);
    }

    public JdbcPagingException() {
        super();
    }

    public JdbcPagingException(String message, Throwable cause) {
        super(message, cause);
    }

    public JdbcPagingException(Throwable cause) {
        super(cause);
    }

    protected JdbcPagingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

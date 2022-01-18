package trilha.back.financys.ExceptionsHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class DivisaoZeroException extends RuntimeException {


    private static final long serialVersionUid = 1L;
    public DivisaoZeroException(String message, Throwable cause){
        super(message, cause);
    }
    public DivisaoZeroException(String message){
        super(message);
    }
}

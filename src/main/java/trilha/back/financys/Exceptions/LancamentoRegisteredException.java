package trilha.back.financys.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LancamentoRegisteredException extends RuntimeException{
    private static final long serialVerionUID = 1L;

    public LancamentoRegisteredException(String message, Throwable cause){
        super(message, cause);
    }

    public LancamentoRegisteredException(String message){
        super(message);
    }
}

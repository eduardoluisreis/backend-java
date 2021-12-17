package trilha.back.financys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LancamentoNotFoundException extends RuntimeException{
    public LancamentoNotFoundException(String message, Long id){
        super(message);
    }
}

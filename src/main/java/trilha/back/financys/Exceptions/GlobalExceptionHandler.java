package trilha.back.financys.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<GlobalExceptionHandler> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        GlobalExceptionHandler error = new GlobalExceptionHandler(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<String> nullPointerException(NullPointerException nullPointerException){
//        return new ResponseEntity<String>
//                ("Null Pointer Exception", HttpStatus.NO_CONTENT);
//    }

    @ExceptionHandler(DivisaoZeroException.class)
    public ResponseEntity<String> divisaoZeroException(DivisaoZeroException divisaoZeroException){
        return new ResponseEntity<String>
                ("Nenhum número pode ser dividido por zero", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoriaNotFoundException.class)
    public ResponseEntity<String> categoriaNotFoundException(CategoriaNotFoundException categoriaNotFoundException){
        return new ResponseEntity<String>("O ID da Categoria não foi encontrado.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LancamentosNotFoundException.class)
    public ResponseEntity<String> lancamentosNotFoundException(LancamentosNotFoundException lancamentosNotFoundException){
        return new ResponseEntity<String>("O ID do Lançamento não foi encontrado",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LancamentosRegisteredException.class)
    public ResponseEntity<String> lancamentoRegisteredException( LancamentosRegisteredException lancamentoRegisteredException){
        return new ResponseEntity<String>("Lançamento já existente na base de dados", HttpStatus.BAD_REQUEST);
    }

    private Integer status;
    private Long timestamp;
    private String message;

    public GlobalExceptionHandler(){
        super();
    }

    public GlobalExceptionHandler(Integer status, Long timestamp, String message) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

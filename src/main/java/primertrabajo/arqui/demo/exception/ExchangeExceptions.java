package primertrabajo.arqui.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import primertrabajo.arqui.demo.dto.ResponseDto;

@ControllerAdvice
public class ExchangeExceptions {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity <ResponseDto<Void>>  exchangeException (IllegalArgumentException e) {
        ResponseDto<Void> response = new ResponseDto<>();
        response.setSuccess(false);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

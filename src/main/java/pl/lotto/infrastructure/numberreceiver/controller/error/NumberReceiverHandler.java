package pl.lotto.infrastructure.numberreceiver.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.lotto.domain.numberreceiver.exception.NumberReceiverNotFoundException;

@RestControllerAdvice
public class NumberReceiverHandler {

    @ExceptionHandler(NumberReceiverNotFoundException.class)
    ResponseEntity<NumberReceiverErrorResponse>handlerNumberReceiverNotFound(NumberReceiverNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NumberReceiverErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND));
    }
}

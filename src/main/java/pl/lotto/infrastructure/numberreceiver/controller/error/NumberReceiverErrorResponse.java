package pl.lotto.infrastructure.numberreceiver.controller.error;

import org.springframework.http.HttpStatus;

record NumberReceiverErrorResponse(String message,
                                   HttpStatus status){
}

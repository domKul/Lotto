package pl.lotto.domain.numberreceiver.exception;

public class NumberReceiverNotFoundException extends RuntimeException{
    public NumberReceiverNotFoundException(String hash) {
        super(String.format("Not found With given id: %s", hash));
    }
}

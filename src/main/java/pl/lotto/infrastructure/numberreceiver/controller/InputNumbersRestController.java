package pl.lotto.infrastructure.numberreceiver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lotto.domain.numberreceiver.NumberReceiverFacade;
import pl.lotto.domain.numberreceiver.dto.NumberReceiverResponseDto;
import pl.lotto.domain.numberreceiver.dto.TicketDto;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/inputNumbers")
@Log4j2
@RequiredArgsConstructor
public class InputNumbersRestController {

    private final NumberReceiverFacade numberReceiverFacade;

    @PostMapping(value = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NumberReceiverResponseDto> inputNumbers(@RequestBody InputNumbersRequestDto requestDto) {
        Set<Integer> distinctNumbers = new HashSet<>(requestDto.inputNumbers());
        NumberReceiverResponseDto numberReceiverResponseDto = numberReceiverFacade.inputNumbers(distinctNumbers);
        return ResponseEntity.ok(numberReceiverResponseDto);
    }

    @GetMapping("/{hash}")
    public ResponseEntity<TicketDto> inputNumbers(@PathVariable String hash) {
        TicketDto byHash = numberReceiverFacade.findByHash(hash);
        return ResponseEntity.ok(byHash);
    }
}

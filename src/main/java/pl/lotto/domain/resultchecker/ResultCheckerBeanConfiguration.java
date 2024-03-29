package pl.lotto.domain.resultchecker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lotto.domain.numbergenerator.WinningNumbersGeneratorFacade;
import pl.lotto.domain.numberreceiver.NumberReceiverFacade;

@Configuration
class ResultCheckerBeanConfiguration {

    @Bean
    WinnersRetriever winnersRetriever() {
        return new WinnersRetriever();
    }

    @Bean
    ResultCheckerFacade resultCheckerFacade(WinningNumbersGeneratorFacade winningNumbersGeneratorFacade,
                                            NumberReceiverFacade numberReceiverFacade, PlayerRepository playerRepository) {
        return new ResultCheckerFacade(winningNumbersGeneratorFacade, numberReceiverFacade, playerRepository, winnersRetriever());
    }

    ResultCheckerFacade createForTest(WinningNumbersGeneratorFacade generatorFacade, NumberReceiverFacade receiverFacade, PlayerRepository playerRepository) {
        WinnersRetriever winnerGenerator = new WinnersRetriever();
        return new ResultCheckerFacade(generatorFacade, receiverFacade, playerRepository, winnerGenerator);
    }
}

package pl.lotto.domain.resultannouncer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lotto.domain.resultchecker.ResultCheckerFacade;

import java.time.Clock;

@Configuration
class ResultAnnouncerBeanConfiguration {

    @Bean
    ResultAnnouncerFacade resultAnnouncerFacade(ResultCheckerFacade resultAnnouncerFacade,
                                                ResponseRepository responseRepository,Clock clock){
        return new ResultAnnouncerFacade(resultAnnouncerFacade,responseRepository,clock);
    }

    ResultAnnouncerFacade createForTest(ResultCheckerFacade resultCheckerFacade,
                                        ResponseRepository responseRepository, Clock clock) {
        return new ResultAnnouncerFacade(resultCheckerFacade, responseRepository, clock);
    }
}

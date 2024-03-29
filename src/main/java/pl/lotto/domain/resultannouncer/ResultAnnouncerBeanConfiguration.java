package pl.lotto.domain.resultannouncer;

import java.time.Clock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lotto.domain.resultchecker.ResultCheckerFacade;

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

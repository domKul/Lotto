package pl.lotto.domain.resultannouncer;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ResponseRepository extends MongoRepository<ResultResponse,String> {
}

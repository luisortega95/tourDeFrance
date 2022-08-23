package co.com.sofka.mongo.documents.cyclist;

import co.com.sofka.model.cyclist.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;

public interface MongoDBRepositoryCyclist extends ReactiveMongoRepository<CyclistDocument, String>, ReactiveQueryByExampleExecutor<CyclistDocument> {

}

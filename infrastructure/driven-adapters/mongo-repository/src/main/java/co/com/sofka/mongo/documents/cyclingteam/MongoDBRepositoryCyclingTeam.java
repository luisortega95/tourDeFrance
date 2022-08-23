package co.com.sofka.mongo.documents.cyclingteam;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryCyclingTeam extends ReactiveMongoRepository<CyclingTeamDocument, String>, ReactiveQueryByExampleExecutor<CyclingTeamDocument> {
}

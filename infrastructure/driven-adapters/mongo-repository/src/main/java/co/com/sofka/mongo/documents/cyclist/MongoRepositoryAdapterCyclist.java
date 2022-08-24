package co.com.sofka.mongo.documents.cyclist;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Repository
public class MongoRepositoryAdapterCyclist extends AdapterOperations<Cyclist, CyclistDocument, String, MongoDBRepositoryCyclist>
        implements CyclistRepository {

    public MongoRepositoryAdapterCyclist(MongoDBRepositoryCyclist repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Cyclist.class));
    }

    @Override
    public Mono<Cyclist> update(String id, Cyclist cyclist) {
        cyclist.setId(id);
        return repository
                .save(new CyclistDocument(cyclist.getId(), cyclist.getFullName(), cyclist.getCompetitorNumber(),
                        cyclist.getCountry(), cyclist.getCyclingTeamCode()))
                .flatMap(element -> Mono.just(cyclist));
    }

    @Override
    public Flux<Cyclist> findCyclistsByCountry(String country) {
        return repository.findAll()
                .filter(cyclist -> cyclist.getCountry().equals(country))
                .map(m -> mapper.map(m, Cyclist.class));
    }

    @Override
    public Flux<Cyclist> findCyclistsByTeamCode(String teamCode) {
        return repository.findAll()
                .filter(cyclist -> cyclist.getCyclingTeamCode().equals(teamCode))
                .map(m -> mapper.map(m, Cyclist.class));
    }



}

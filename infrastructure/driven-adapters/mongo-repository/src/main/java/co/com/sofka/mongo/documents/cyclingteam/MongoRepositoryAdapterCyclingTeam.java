package co.com.sofka.mongo.documents.cyclingteam;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import co.com.sofka.model.cyclingteam.gateways.CyclingTeamRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapterCyclingTeam extends AdapterOperations<CyclingTeam, CyclingTeamDocument, String, MongoDBRepositoryCyclingTeam>
        implements CyclingTeamRepository {

    public MongoRepositoryAdapterCyclingTeam(MongoDBRepositoryCyclingTeam repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, CyclingTeam.class));
    }

    @Override
    public Mono<CyclingTeam> update(String id, CyclingTeam cyclingTeam) {
        cyclingTeam.setId(id);
        return repository
                .save(new CyclingTeamDocument(cyclingTeam.getId(), cyclingTeam.getName(), cyclingTeam.getTeamCode(), cyclingTeam.getCountry(), cyclingTeam.getNumberOfCyclists()))
                .flatMap(element -> Mono.just(cyclingTeam));
    }

    @Override
    public Flux<CyclingTeam> findCyclingTeamsByCountry(String country) {
        return repository.findAll()
                .filter(cyclingTeam -> cyclingTeam.getCountry().equals(country))
                .map(m -> mapper.map(m, CyclingTeam.class));
    }

    @Override
    public Flux<CyclingTeam> findCyclingTeamByTeamCode(String teamCode) {
        return repository.findAll()
                .filter(cyclingTeam -> cyclingTeam.getTeamCode().equals(teamCode))
                .map(m -> mapper.map(m, CyclingTeam.class));
    }
}

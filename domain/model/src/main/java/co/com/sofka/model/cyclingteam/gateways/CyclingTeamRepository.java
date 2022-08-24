package co.com.sofka.model.cyclingteam.gateways;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz para entidad equipo de ciclismo
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
public interface CyclingTeamRepository {

    Mono<CyclingTeam> save(CyclingTeam cyclingTeam);

    Flux<CyclingTeam> findAll();

    Mono<CyclingTeam> findById(String id);

    Mono<CyclingTeam> update(String id, CyclingTeam cyclingTeam);

    Mono<Void> deleteById(String id);

    Flux<CyclingTeam> findCyclingTeamsByCountry(String country);

    Mono<CyclingTeam> findCyclingTeamByTeamCode(String teamCode);

}

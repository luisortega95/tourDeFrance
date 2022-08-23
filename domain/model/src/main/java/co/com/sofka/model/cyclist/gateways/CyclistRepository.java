package co.com.sofka.model.cyclist.gateways;

import co.com.sofka.model.cyclist.Cyclist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz para entidad ciclista
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
public interface CyclistRepository {

    Mono<Cyclist> save(Cyclist cyclist);

    Flux<Cyclist> findAll();

    Mono<Cyclist> findById(String id);

    Mono<Cyclist> update(String id, Cyclist cyclist);

    Mono<Void> deleteById(String id);

    Flux<Cyclist> findCyclistsByCountry(String country);

    Flux<Cyclist> findCyclistsByTeamCode(String teamCode);
}

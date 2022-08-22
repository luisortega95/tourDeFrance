package co.com.sofka.model.cyclist.gateways;

import co.com.sofka.model.cyclist.Cyclist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interface for Cyclist Model
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CyclistRepository {

    Mono<Cyclist> save(Cyclist cyclist);

    Flux<Cyclist> findAll();

    Mono<Cyclist> findById();

    Mono<Cyclist> update(String id, Cyclist cyclist);

    Mono<Void> deleteById(String id);
}

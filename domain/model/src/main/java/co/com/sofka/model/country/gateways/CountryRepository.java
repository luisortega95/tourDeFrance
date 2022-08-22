package co.com.sofka.model.country.gateways;

import co.com.sofka.model.country.Country;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interface for Country Model
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CountryRepository {

    Mono<Country> save(Country country);

    Flux<Country> findAll();

    Mono<Country> findById();

    Mono<Country> update(String id, Country country);

    Mono<Void> deleteById(String id);
}

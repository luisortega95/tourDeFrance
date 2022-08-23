package co.com.sofka.usecase.cyclist.getcyclistsbycountry;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Function;

/**
 * Caso de uso para obtener ciclistas por pais
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetCyclistsByCountryUseCase implements Function<String, Flux<Cyclist>> {

    private final CyclistRepository cyclistRepository;

    @Override
    public Flux<Cyclist> apply(String country) {
        return cyclistRepository.findCyclistsByCountry(country);
    }
}

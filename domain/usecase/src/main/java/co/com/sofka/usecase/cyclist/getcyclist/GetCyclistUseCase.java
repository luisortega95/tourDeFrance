package co.com.sofka.usecase.cyclist.getcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.usecase.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Caso de uso para obtener ciclista por ID
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetCyclistUseCase implements Function<String, Mono<Cyclist>> {

    private final CyclistRepository cyclistRepository;


    @Override
    public Mono<Cyclist> apply(String id) {
        return cyclistRepository.findById(id)
                .switchIfEmpty(Mono.error(new ErrorMessage("No existe el ciclista")));
    }
}

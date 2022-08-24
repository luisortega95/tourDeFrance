package co.com.sofka.usecase.cyclist.updatecyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.usecase.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

/**
 * Caso de uso para actualizar ciclista por ID
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class UpdateCyclistUseCase implements BiFunction<String, Cyclist, Mono<Cyclist>> {

    private final CyclistRepository cyclistRepository;

    @Override
    public Mono<Cyclist> apply(String id, Cyclist cyclist) {
        return cyclistRepository.update(id, cyclist)
                .switchIfEmpty(Mono.error(new ErrorMessage("No existe el ciclista")));
    }
}

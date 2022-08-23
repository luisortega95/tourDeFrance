package co.com.sofka.usecase.cyclist.deletecyclist;

import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Caso de uso para eliminar ciclista por ID
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class DeleteCyclistUseCase implements Function<String, Mono<Void>> {

    private final CyclistRepository cyclistRepository;

    @Override
    public Mono<Void> apply(String id) {
        return cyclistRepository.deleteById(id);
    }
}

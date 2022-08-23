package co.com.sofka.usecase.cyclist.getallcyclists;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

/**
 * Caso de uso para obtener todos los ciclistas
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetAllCyclistsUseCase implements Supplier<Flux<Cyclist>> {

    private final CyclistRepository cyclistRepository;

    @Override
    public Flux<Cyclist> get() {
        return cyclistRepository.findAll();
    }
}

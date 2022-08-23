package co.com.sofka.usecase.cyclingteam.deletecyclingteam;

import co.com.sofka.model.cyclingteam.gateways.CyclingTeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Caso de uso para eliminar equipo de ciclismo por ID
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class DeleteCyclingTeamUseCase implements Function<String, Mono<Void>> {

    private final CyclingTeamRepository cyclingTeamRepository;

    @Override
    public Mono<Void> apply(String id) {
        return cyclingTeamRepository.deleteById(id);
    }
}

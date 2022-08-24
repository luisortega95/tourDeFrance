package co.com.sofka.usecase.cyclingteam.deletecyclingteam;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import co.com.sofka.model.cyclingteam.gateways.CyclingTeamRepository;
import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.usecase.exception.ErrorMessage;
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
        return cyclingTeamRepository.findById(id)
                .switchIfEmpty(Mono.error(new ErrorMessage("No existe el equipo de ciclismo")))
                .map(CyclingTeam::getId)
                .flatMap(cyclingTeamRepository::deleteById);
    }
}

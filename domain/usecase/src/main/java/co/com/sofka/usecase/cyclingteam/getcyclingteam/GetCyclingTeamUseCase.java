package co.com.sofka.usecase.cyclingteam.getcyclingteam;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import co.com.sofka.model.cyclingteam.gateways.CyclingTeamRepository;
import co.com.sofka.usecase.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Caso de uso para obtener equipo de ciclismo por ID
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetCyclingTeamUseCase implements Function<String, Mono<CyclingTeam>> {

    private final CyclingTeamRepository cyclingTeamRepository;

    @Override
    public Mono<CyclingTeam> apply(String id) {
        return cyclingTeamRepository.findById(id)
                .switchIfEmpty(Mono.error(new ErrorMessage("No existe el equipo de ciclismo")));
    }
}

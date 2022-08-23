package co.com.sofka.usecase.cyclingteam.updatecyclingteam;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import co.com.sofka.model.cyclingteam.gateways.CyclingTeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

/**
 * Caso de uso para actualizar equipo de ciclismo por ID
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class UpdateCyclingTeamUseCase implements BiFunction<String, CyclingTeam, Mono<CyclingTeam>> {

    private final CyclingTeamRepository cyclingTeamRepository;

    @Override
    public Mono<CyclingTeam> apply(String id, CyclingTeam cyclingTeam) {
        return cyclingTeamRepository.update(id, cyclingTeam);
    }
}

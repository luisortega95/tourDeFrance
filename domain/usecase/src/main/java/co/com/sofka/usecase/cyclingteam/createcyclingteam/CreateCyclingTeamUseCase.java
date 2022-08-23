package co.com.sofka.usecase.cyclingteam.createcyclingteam;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import co.com.sofka.model.cyclingteam.gateways.CyclingTeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Caso de uso para crear equipo de ciclismo
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class CreateCyclingTeamUseCase implements Function<CyclingTeam, Mono<CyclingTeam>> {

    private final CyclingTeamRepository cyclingTeamRepository;

    @Override
    public Mono<CyclingTeam> apply(CyclingTeam cyclingTeam) {
        return cyclingTeamRepository.save(cyclingTeam);
    }
}

package co.com.sofka.usecase.cyclingteam.getallcyclingteams;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import co.com.sofka.model.cyclingteam.gateways.CyclingTeamRepository;
import co.com.sofka.usecase.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

/**
 * Caso de uso para obtener todos los equipos de ciclismo
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetAllCyclingTeamsUseCase implements Supplier<Flux<CyclingTeam>> {

    private final CyclingTeamRepository cyclingTeamRepository;

    @Override
    public Flux<CyclingTeam> get() {
        return cyclingTeamRepository.findAll()
                .switchIfEmpty(Mono.error(new ErrorMessage("No existen equipos de ciclismo")));
    }
}

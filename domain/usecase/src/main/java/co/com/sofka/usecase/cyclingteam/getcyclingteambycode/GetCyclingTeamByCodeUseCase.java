package co.com.sofka.usecase.cyclingteam.getcyclingteambycode;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import co.com.sofka.model.cyclingteam.gateways.CyclingTeamRepository;
import co.com.sofka.usecase.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class GetCyclingTeamByCodeUseCase implements Function<String, Flux<CyclingTeam>> {

    private final CyclingTeamRepository cyclingTeamRepository;

    @Override
    public Flux<CyclingTeam> apply(String teamCode) {
        return cyclingTeamRepository.findCyclingTeamByTeamCode(teamCode)
                .switchIfEmpty(Mono.error(new ErrorMessage("No existe el equipo de ciclismo por ese codigo")));
    }
}

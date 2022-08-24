package co.com.sofka.usecase.cyclist.createcyclist;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import co.com.sofka.model.cyclingteam.gateways.CyclingTeamRepository;
import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.usecase.cyclist.getcyclistsbyteamcode.GetCyclistsByTeamCodeUseCase;
import co.com.sofka.usecase.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Caso de uso para crear ciclista
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class CreateCyclistUseCase implements Function<Cyclist, Mono<Cyclist>> {

    private final CyclistRepository cyclistRepository;
    private final CyclingTeamRepository cyclingTeamRepository;

    private final GetCyclistsByTeamCodeUseCase getCyclistsByTeamCodeUseCase;


    @Override
    public Mono<Cyclist> apply(Cyclist cyclist) {
//        cyclingTeamRepository.findCyclingTeamByTeamCode(cyclist.getCyclingTeamCode())
//                .map(cyclingTeam -> {
//                    cyclingTeam.getNumberOfCyclists();
//                    return cyclingTeam;
//                })
//                .flatMap(null);
        return cyclistRepository.findCyclistsByTeamCode(cyclist.getCyclingTeamCode())
                .count()
                .flatMap(cyclists -> {
                    if (cyclists > 7) {
                        return Mono.error(new ErrorMessage("El equipo ya tiene el maximo de 8 ciclistas "));
                    }
                    return cyclistRepository.save(cyclist);
                });
    }
}

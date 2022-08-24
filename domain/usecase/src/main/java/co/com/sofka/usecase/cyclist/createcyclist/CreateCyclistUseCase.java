package co.com.sofka.usecase.cyclist.createcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.usecase.cyclingteam.getcyclingteambycode.GetCyclingTeamByCodeUseCase;
import co.com.sofka.usecase.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

/**
 * Caso de uso para crear ciclista
 *
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class CreateCyclistUseCase implements Function<Cyclist, Mono<Cyclist>> {

    private final CyclistRepository cyclistRepository;

    private final GetCyclingTeamByCodeUseCase getCyclingTeamByCodeUseCase;


    @Override
    public Mono<Cyclist> apply(Cyclist cyclist) {
        return getCyclingTeamByCodeUseCase.apply(cyclist.getCyclingTeamCode())
                .flatMap(cyclingTeam -> cyclistRepository.findCyclistsByTeamCode(cyclist.getCyclingTeamCode())
                        .count()
                        .flatMap(cyclists -> {
                            if (cyclists > 7) return Mono.error(new Throwable());
                            return cyclistRepository.save(cyclist);
                        }))
                .onErrorResume(error -> {
                    if (Objects.equals(error.getMessage(), "Source was empty"))
                        return Mono.error(new ErrorMessage("El codigo del equipo es incorrecto"));
                    return Mono.error(new ErrorMessage("El equipo ya tiene el maximo de 8 ciclistas"));
                });
    }
}

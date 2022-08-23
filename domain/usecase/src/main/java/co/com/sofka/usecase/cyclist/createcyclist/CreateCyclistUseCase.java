package co.com.sofka.usecase.cyclist.createcyclist;

import co.com.sofka.model.cyclingteam.gateways.CyclingTeamRepository;
import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
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


    @Override
    public Mono<Cyclist> apply(Cyclist cyclist) {
//        return cyclistRepository.save(cyclist);
        return cyclistRepository.findCyclistsByTeamCode(cyclist.getCyclingTeam().getTeamCode())
                .count()
                .flatMap(cyclists -> {
                    if (cyclists > 7) {
                        return Mono.error(new IllegalArgumentException("El equipo ya tiene 8 ciclistas"));
                    }
                    return cyclistRepository.save(cyclist);
                });
    }
}

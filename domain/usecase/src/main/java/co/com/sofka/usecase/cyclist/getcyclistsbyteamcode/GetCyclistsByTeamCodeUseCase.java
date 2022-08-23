package co.com.sofka.usecase.cyclist.getcyclistsbyteamcode;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;


import java.util.function.Function;

/**
 * Caso de uso para obtener ciclistas por codigo de equipo
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetCyclistsByTeamCodeUseCase implements Function<String, Flux<Cyclist>> {

    private final CyclistRepository cyclistRepository;


    @Override
    public Flux<Cyclist> apply(String teamCode) {
        return cyclistRepository.findCyclistsByTeamCode(teamCode);
    }
}

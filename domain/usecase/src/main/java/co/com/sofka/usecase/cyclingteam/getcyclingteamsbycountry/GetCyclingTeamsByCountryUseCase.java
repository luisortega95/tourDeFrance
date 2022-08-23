package co.com.sofka.usecase.cyclingteam.getcyclingteamsbycountry;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import co.com.sofka.model.cyclingteam.gateways.CyclingTeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Function;

/**
 * Caso de uso para obtener equipos de ciclismo por pais
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetCyclingTeamsByCountryUseCase implements Function<String, Flux<CyclingTeam>> {

    private final CyclingTeamRepository cyclingTeamRepository;

    @Override
    public Flux<CyclingTeam> apply(String country) {
        return cyclingTeamRepository.findCyclingTeamsByCountry(country);
    }
}

package co.com.sofka.api.cyclingteam;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.usecase.cyclingteam.createcyclingteam.CreateCyclingTeamUseCase;
import co.com.sofka.usecase.cyclingteam.deletecyclingteam.DeleteCyclingTeamUseCase;
import co.com.sofka.usecase.cyclingteam.getallcyclingteams.GetAllCyclingTeamsUseCase;
import co.com.sofka.usecase.cyclingteam.getcyclingteam.GetCyclingTeamUseCase;
import co.com.sofka.usecase.cyclingteam.getcyclingteamsbycountry.GetCyclingTeamsByCountryUseCase;
import co.com.sofka.usecase.cyclingteam.updatecyclingteam.UpdateCyclingTeamUseCase;
import co.com.sofka.usecase.cyclist.createcyclist.CreateCyclistUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Controlador para equipo de ciclismo
 *
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@Component
@RequiredArgsConstructor
public class CyclingTeamHandler {

    private final CreateCyclingTeamUseCase createCyclingTeamUseCase;

    private final GetCyclingTeamUseCase getCyclingTeamUseCase;

    private final GetAllCyclingTeamsUseCase getAllCyclingTeamsUseCase;

    private final UpdateCyclingTeamUseCase updateCyclingTeamUseCase;

    private final DeleteCyclingTeamUseCase deleteCyclingTeamUseCase;

    private final GetCyclingTeamsByCountryUseCase getCyclingTeamsByCountryUseCase;

    public Mono<ServerResponse> createCyclingTeam(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(CyclingTeam.class)
                .flatMap(createCyclingTeamUseCase)
                .flatMap(cyclingTeam -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(cyclingTeam));
    }

    public Mono<ServerResponse> getCyclingTeam(ServerRequest serverRequest) {
        return Mono.just(serverRequest.pathVariable("id"))
                .flatMap(getCyclingTeamUseCase)
                .flatMap(cyclingTeam -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(cyclingTeam));
    }

    public Mono<ServerResponse> getAllCyclingTeams(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllCyclingTeamsUseCase.get(), CyclingTeam.class));
    }

    public Mono<ServerResponse> updateCyclingTeam(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(CyclingTeam.class)
                .zipWith(Mono.just(serverRequest.pathVariable("id")))
                .flatMap(objects -> updateCyclingTeamUseCase.apply(objects.getT2(), objects.getT1()))
                .flatMap(cyclingTeam -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(cyclingTeam));
    }

    public Mono<ServerResponse> deleteCyclingTeam(ServerRequest serverRequest) {
        return Mono.just(serverRequest.pathVariable("id"))
                .flatMap(deleteCyclingTeamUseCase)
                .flatMap(cyclingTeam -> ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(cyclingTeam));
    }

    public Mono<ServerResponse> getCyclingTeamByCountry(ServerRequest serverRequest) {
        var cyclingTeam = serverRequest.pathVariable("country");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getCyclingTeamsByCountryUseCase.apply(cyclingTeam), CyclingTeam.class);
    }
}

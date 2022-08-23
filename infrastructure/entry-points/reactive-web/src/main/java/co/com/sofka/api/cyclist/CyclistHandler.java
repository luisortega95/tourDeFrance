package co.com.sofka.api.cyclist;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.usecase.cyclingteam.getallcyclingteams.GetAllCyclingTeamsUseCase;
import co.com.sofka.usecase.cyclist.createcyclist.CreateCyclistUseCase;
import co.com.sofka.usecase.cyclist.deletecyclist.DeleteCyclistUseCase;
import co.com.sofka.usecase.cyclist.getallcyclists.GetAllCyclistsUseCase;
import co.com.sofka.usecase.cyclist.getcyclist.GetCyclistUseCase;
import co.com.sofka.usecase.cyclist.getcyclistsbycountry.GetCyclistsByCountryUseCase;
import co.com.sofka.usecase.cyclist.getcyclistsbyteamcode.GetCyclistsByTeamCodeUseCase;
import co.com.sofka.usecase.cyclist.updatecyclist.UpdateCyclistUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Controlador para ciclista
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@Component
@RequiredArgsConstructor
public class CyclistHandler {

    private final CreateCyclistUseCase createCyclistUseCase;

    private final GetCyclistUseCase getCyclistUseCase;

    private final GetAllCyclistsUseCase getAllCyclistsUseCase;

    private final GetCyclistsByCountryUseCase getCyclistsByCountryUseCase;

    private final GetCyclistsByTeamCodeUseCase getCyclistsByTeamCodeUseCase;

    private final UpdateCyclistUseCase updateCyclistUseCase;

    private final DeleteCyclistUseCase deleteCyclistUseCase;

    public Mono<ServerResponse> createCyclist(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Cyclist.class)
                .flatMap(createCyclistUseCase)
                .flatMap(cyclist -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(cyclist));
    }

    public Mono<ServerResponse> getCyclist(ServerRequest serverRequest) {
        return Mono.just(serverRequest.pathVariable("id"))
                .flatMap(getCyclistUseCase)
                .flatMap(cyclist -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(cyclist));
    }

    public Mono<ServerResponse> getAllCyclists(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllCyclistsUseCase.get(), Cyclist.class));
    }

    public Mono<ServerResponse> updateCyclist(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Cyclist.class)
                .zipWith(Mono.just(serverRequest.pathVariable("id")))
                .flatMap(objects -> updateCyclistUseCase.apply(objects.getT2(), objects.getT1()))
                .flatMap(cyclist -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(cyclist));
    }

    public Mono<ServerResponse> deleteCyclist(ServerRequest serverRequest) {
        return Mono.just(serverRequest.pathVariable("id"))
                .flatMap(deleteCyclistUseCase)
                .flatMap(cyclist -> ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(cyclist));
    }

    public Mono<ServerResponse> getCyclistByCountry(ServerRequest serverRequest) {
        var cyclist = serverRequest.pathVariable("country");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getCyclistsByCountryUseCase.apply(cyclist), CyclingTeam.class);
    }

    public Mono<ServerResponse> getCyclistByTeamCode(ServerRequest serverRequest) {
        var cyclist = serverRequest.pathVariable("team-code");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getCyclistsByTeamCodeUseCase.apply(cyclist), CyclingTeam.class);
    }
}

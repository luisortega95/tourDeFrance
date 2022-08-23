package co.com.sofka.api.cyclingteam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Rutas para equipo de ciclismo
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@Configuration
public class CyclingTeamRouterRest {

    @Bean
    public RouterFunction<ServerResponse> cyclingTeamRouterFunction(CyclingTeamHandler cyclingTeamHandler) {
        return route(GET("/api/cycling-team"), cyclingTeamHandler::getCyclingTeam)
                .andRoute(POST("/api/cycling-team"), cyclingTeamHandler::createCyclingTeam)
                .andRoute(PUT("/api/cycling-team/{id}"), cyclingTeamHandler::updateCyclingTeam)
                .andRoute(DELETE("/api/cycling-team/{id}"), cyclingTeamHandler::deleteCyclingTeam)
                .andRoute(GET("/api/cycling-teams"), cyclingTeamHandler::getAllCyclingTeams)
                .and(route(GET("/api/cycling-team/{country}"), cyclingTeamHandler::getCyclingTeamByCountry));

    }
}

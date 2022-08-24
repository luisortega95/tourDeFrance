package co.com.sofka.api.cyclist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Rutas para ciclista
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@Configuration
public class CyclistRouterRest {

    @Bean
    public RouterFunction<ServerResponse> cyclistRouterFunction(CyclistHandler cyclistHandler) {
        return route(GET("/api/cyclist"), cyclistHandler::getCyclist)
                .andRoute(POST("/api/cyclist"), cyclistHandler::createCyclist)
                .andRoute(PUT("/api/cyclist/{id}"), cyclistHandler::updateCyclist)
                .andRoute(DELETE("/api/cyclist/{id}"), cyclistHandler::deleteCyclist)
                .andRoute(GET("/api/cyclists"), cyclistHandler::getAllCyclists)
                .andRoute(GET("/api/cyclist/country/{country}"), cyclistHandler::getCyclistByCountry)
                .and(route(GET("/api/cyclist/team/{code}"), cyclistHandler::getCyclistByTeamCode));
    }
}

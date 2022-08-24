package co.com.sofka.model.cyclingteam;

import co.com.sofka.model.cyclist.Cyclist;
import lombok.*;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

import java.util.List;

/**
 * Entidad equipo de ciclismo
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CyclingTeam {

    private String id;
    private String name;
    private String teamCode;
    private String country;
}

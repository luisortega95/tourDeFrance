package co.com.sofka.model.cyclist;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import lombok.*;

/**
 * Entidad ciclista
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Cyclist {

    private String id;
    private String fullName;
    private String competitorNumber;
    private String country;
    private String cyclingTeamCode;
}

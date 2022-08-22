package co.com.sofka.model.country;
import co.com.sofka.model.cyclingteam.CyclingTeam;
import co.com.sofka.model.cyclist.Cyclist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entity Country
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Country {

    private String id;
    private String name;
    private String code;
    private List<CyclingTeam> cyclingTeams;
    private List<Cyclist> cyclists;
}


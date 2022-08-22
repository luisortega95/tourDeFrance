package co.com.sofka.model.cyclingteam;
import co.com.sofka.model.country.Country;
import co.com.sofka.model.cyclist.Cyclist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entity CyclingTeam
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0
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
    private Country country;
    private List<Cyclist> cyclists;
}

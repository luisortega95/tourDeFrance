package co.com.sofka.model.cyclist;
import co.com.sofka.model.country.Country;
import co.com.sofka.model.cyclingteam.CyclingTeam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity Cyclist
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0
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
    private Country country;
    private CyclingTeam cyclingTeam;
}

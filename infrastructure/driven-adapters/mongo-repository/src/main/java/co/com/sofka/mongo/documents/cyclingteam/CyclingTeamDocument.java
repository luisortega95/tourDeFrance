package co.com.sofka.mongo.documents.cyclingteam;

import co.com.sofka.model.cyclist.Cyclist;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNullFields;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Documento de la entidad equipo de ciclismo
 *
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "cyclingTeam")
public class CyclingTeamDocument {

    @Id
    private String id;

    @NotNull(message = "El nuombre es obligatorio")
    private String name;

    @Indexed(unique = true)
    @Size(max = 3)
    @NotNull(message = "El codigo de equipo es obligatorio")
    private String teamCode;

    @NotNull(message = "El pais es obligatorio")
    private String country;

    private Integer numberOfCyclists;
}

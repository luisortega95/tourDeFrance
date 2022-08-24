package co.com.sofka.mongo.documents.cyclist;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Documento de la entidad ciclista
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "cyclists")
public class CyclistDocument {

    @Id
    private String id;

    @NotNull(message = "El nombre es obligatorio")
    private String fullName;

    @Indexed(unique = true)
    @Size(max = 3)
    @NotNull(message = "El numero de competidor es obligatorio")
    private String competitorNumber;

    @NotNull(message = "El pais es obligatorio")
    private String country;

    @NotNull(message = "El equipo es obligatorio")
    @Size(max = 3)
    private String cyclingTeamCode;
}

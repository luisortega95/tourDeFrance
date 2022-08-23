package co.com.sofka.mongo.documents.cyclist;

import co.com.sofka.model.cyclingteam.CyclingTeam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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

    private String fullName;

    @Indexed(unique = true)
    private String competitorNumber;

    private String country;

    private CyclingTeam cyclingTeam;
}

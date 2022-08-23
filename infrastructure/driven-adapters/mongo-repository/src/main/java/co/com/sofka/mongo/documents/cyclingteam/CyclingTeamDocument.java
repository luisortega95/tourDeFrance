package co.com.sofka.mongo.documents.cyclingteam;

import co.com.sofka.model.cyclist.Cyclist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(value = "cyclists")
public class CyclingTeamDocument {

    @Id
    private String id;

    private String name;

    @Indexed(unique = true)
    private String teamCode;

    private String country;

    private List<Cyclist> cyclists;
}

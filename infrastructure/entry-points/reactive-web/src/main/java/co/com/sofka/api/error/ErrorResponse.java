package co.com.sofka.api.error;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase response de mensaje de error
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class ErrorResponse {
    private String name;
    private String message;
    private int status;
}

package co.com.sofka.usecase.exception;


/**
 * Clase para mostrar mensajes de errores
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-02-22
 * @since 1.0.0
 */
public class ErrorMessage extends RuntimeException{

    public ErrorMessage(String message) {
        super(message);
    }
}

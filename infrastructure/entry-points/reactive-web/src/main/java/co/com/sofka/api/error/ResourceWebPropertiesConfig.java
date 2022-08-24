package co.com.sofka.api.error;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuracion de propiedades web
 *
 * @author Ricardo Ortega <luis.ortega@sofka.com.co>
 * @version 1.0.0 2022-08-23
 * @since 1.0.0
 */
@Configuration
public class ResourceWebPropertiesConfig {

    @Bean
    public WebProperties.Resources resources() {
        return new WebProperties.Resources();
    }
}
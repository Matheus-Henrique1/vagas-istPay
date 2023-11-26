package istPay.example.vagasistPay.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class Config {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages"); // Arquivo de propriedades base (por exemplo, messages.properties)
        messageSource.setDefaultEncoding("ISO-8859-1");
        return messageSource;
    }

}

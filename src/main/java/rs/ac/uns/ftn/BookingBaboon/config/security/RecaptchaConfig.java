package rs.ac.uns.ftn.BookingBaboon.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:recaptcha.properties")
public class RecaptchaConfig {
    // This class is used to load the recaptcha.properties file
}

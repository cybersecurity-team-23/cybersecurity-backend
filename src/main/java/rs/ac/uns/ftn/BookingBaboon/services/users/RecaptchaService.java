package rs.ac.uns.ftn.BookingBaboon.services.users;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecaptchaService {
    @Value("${recaptcha.secret.key}")
    private String secretKey;

    private static final String RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    public boolean verifyCaptcha(String token) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("secret", secretKey);
        params.put("response", token);

        Map<String, Object> verificationResult = restTemplate.postForObject(RECAPTCHA_VERIFY_URL, params, Map.class);

        return (Boolean) verificationResult.get("success");
    }
}
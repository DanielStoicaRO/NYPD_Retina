package retina.nypd;

import org.springframework.boot.SpringApplication;
import retina.nypd.config.AppConfig;

/**
 * Welcome NYPD_Retina
 */
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class);
    }
}

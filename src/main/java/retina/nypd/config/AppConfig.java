package retina.nypd.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("retina.nypd")
@EntityScan("retina.nypd.entities")
@EnableJpaRepositories("retina.nypd.repositories")
public class AppConfig {
}

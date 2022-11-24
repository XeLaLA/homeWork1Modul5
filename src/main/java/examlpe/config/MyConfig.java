package examlpe.config;

import examlpe.storage.Worker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan("examlpe")
public class MyConfig {

        @Bean(name = "misha")
        public Worker misha() {
            return new Worker("Миша");
        }

        @Bean(name="zelya")
        public Worker zelya() {
            return new Worker("Зеля");
        }
}

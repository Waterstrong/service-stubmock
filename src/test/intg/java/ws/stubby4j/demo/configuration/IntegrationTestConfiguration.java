package ws.stubby4j.demo.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan(basePackages = {"ws.stubby4j.demo"})
@PropertySources(value = {
        @PropertySource("classpath:application.yml")
})
@EnableAutoConfiguration
public class IntegrationTestConfiguration {
}

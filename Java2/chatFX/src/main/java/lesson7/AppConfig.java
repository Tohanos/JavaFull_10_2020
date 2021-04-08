package lesson7;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("lesson7")
@PropertySource({"classpath:application.properties"})
public class AppConfig {
}

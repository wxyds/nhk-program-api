package love.is.blind.application.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("love.is.blind")
public class AppConfig {

  @Bean
  public ModelMapper modelMapper() {

    return new ModelMapper();
  }
}
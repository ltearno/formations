package fr.lteconsulting.training.appengine.marvels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan( basePackageClasses = ApplicationController.class )
public class ApplicationController
{
	public static void main( String[] args ) throws Exception
	{
		SpringApplication.run( ApplicationController.class, args );
	}

	@Bean
	@Scope( "singleton" )
	public CharactersRepository getMemosRepository()
	{
		CharactersRepository charactersRepository = new CharactersRepository();

		charactersRepository.load();

		return charactersRepository;
	}
}

package fr.lteconsulting;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile( "MockingTestConfiguration" )
@ComponentScan( excludeFilters = @ComponentScan.Filter( type = FilterType.ASSIGNABLE_TYPE, value = Application.class ) )
@Configuration
public class MockingTestConfiguration
{
	@Bean
	@Primary
	public CustomerRepository customerRepositorySpy()
	{
		return Mockito.mock( CustomerRepository.class );
	}
}

package fr.lteconsulting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ActiveProfiles( "MockingTestConfiguration" )
@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = MockingTestConfiguration.class )
@WebAppConfiguration
public class MockingTest
{
	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void testExampleMocking()
	{
		// GIVEN
		Mockito.when( customerRepository.findOne( 1L ) )
				.thenReturn( new Customer( "ahah", "ohoh" ) );

		Customer customer = customerRepository.findOne( 1L );

		Assert.assertEquals( "ahah", customer.getFirstName() );

		// WHEN
		// String actualAddress = addressService.getAddressForUser( "john" );

		// THEN
		// Assert.assertEquals( "5 Bright Corner", actualAddress );
	}
}

package fr.lteconsulting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/customers" )
public class CustomerController
{
	@Autowired
	CustomerRepository customerRepository;

	@GetMapping
	public Iterable<Customer> getAllCustomers()
	{
		return customerRepository.findAll();
	}

	@GetMapping( "/{id}" )
	public Customer getCustomer( @PathVariable( "id" ) long id )
	{
		return customerRepository.findOne( id );
	}

	@PostMapping( consumes = "application/json" )
	public ResponseEntity<Customer> create( @RequestBody Customer customer )
	{
		customer = customerRepository.save( customer );

		return new ResponseEntity<Customer>( customer, HttpStatus.CREATED );
	}

	@PutMapping( consumes = "application/json" )
	public Customer update( @RequestBody Customer customer )
	{
		return customerRepository.save( customer );
	}

	@DeleteMapping( path = "/{id}" )
	public void delete( @PathVariable( "id" ) long id )
	{
		customerRepository.delete( id );
	}
}

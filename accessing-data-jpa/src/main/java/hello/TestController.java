package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	public CustomerRepository repository;
	
	@RequestMapping("/getCustomer")
	public Customer getCustomer(@RequestParam(value="id", defaultValue="1")Long id) {
		return repository.findOne(id);
	}
	
	@RequestMapping("/getAllCustomers")
	public Iterable<Customer> getAllCustomers() {
		return repository.findAll();
	}
	
	@RequestMapping("/insertCustomer/{firstName}/{lastName}")
	public void getAllCustomers(@PathVariable(value="firstName") String firstName,
			@PathVariable(value="lastName") String lastName) {
		repository.save(new Customer(firstName, lastName));
	}
	
}

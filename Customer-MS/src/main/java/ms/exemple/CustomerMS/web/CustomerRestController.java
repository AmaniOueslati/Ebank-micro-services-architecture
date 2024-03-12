package ms.exemple.CustomerMS.web;


import lombok.AllArgsConstructor;
import ms.exemple.CustomerMS.entities.Customer;
import ms.exemple.CustomerMS.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestController {
    private CustomerRepository customerRepository ;


    @GetMapping("/customers")
    public List<Customer> ListCustomers(){
        return customerRepository.findAll() ;
    }


    @GetMapping("customers/{id}")
    public Customer getCustomerById( @PathVariable  Long id ){
        return customerRepository.findById(id).get();
    }


}

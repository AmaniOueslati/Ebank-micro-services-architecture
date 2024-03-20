package ms.exemple.BankAccountMS.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ms.exemple.BankAccountMS.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="Customer-MS")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name="Customer-MS",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
   @CircuitBreaker(name="Customer-MS" , fallbackMethod = "getAllCustomers")
    List<Customer> allCustomers();
     default Customer getDefaultCustomer(Long id , Exception exception){
         Customer customer=new Customer();
         customer.setId(id);
         customer.setFirstName("Not Valid");
         customer.setLastName("Not Valid");
         customer.setEmail("default");
         return  customer;


     }
   default List<Customer> getAllCustomers(Exception exception){
         return List.of();
     }
}

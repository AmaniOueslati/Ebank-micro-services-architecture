package ms.exemple.CustomerMS;

import ms.exemple.CustomerMS.entities.Customer;
import ms.exemple.CustomerMS.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return  args->{
			List<Customer> customerList= List.of(
					Customer.builder()
							.firstName("emna")
							.lastName("oueslati")
							.email("emna@gmail.com")
							.build(),
					Customer.builder()
							.firstName("eya")
							.lastName("oueslati")
							.email("eya@gmail.com")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}

}

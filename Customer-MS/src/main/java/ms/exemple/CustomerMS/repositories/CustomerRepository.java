package ms.exemple.CustomerMS.repositories;

import ms.exemple.CustomerMS.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer , Long > {
}

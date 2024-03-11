package ms.exemple.BankAccountMS.repositories;

import ms.exemple.BankAccountMS.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}

package ms.exemple.BankAccountMS;

import ms.exemple.BankAccountMS.entities.BankAccount;
import ms.exemple.BankAccountMS.enums.AccountType;
import ms.exemple.BankAccountMS.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class BankAccountMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountMsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (BankAccountRepository  bankAccountRepository){
		return args->{

			BankAccount bankAccount1=BankAccount.builder()
					.id(UUID.randomUUID().toString())
					.currency("MAD")
					.solde(9800)
					.DateCreation(LocalDate.now())
					.type(AccountType.CURRENT_ACCOUNT)
					.customerId(Long.valueOf(1))
					.build();
			BankAccount bankAccount2=BankAccount.builder()
					.id(UUID.randomUUID().toString())
					.currency("MAD")
					.solde(7500)
					.DateCreation(LocalDate.now())
					.type(AccountType.SAVING_ACCOUNT)
					.customerId(Long.valueOf(2))
					.build();

			bankAccountRepository.save(bankAccount1);
			bankAccountRepository.save(bankAccount2);

		};
	}
}

package ms.exemple.BankAccountMS;

import ms.exemple.BankAccountMS.clients.CustomerRestClient;
import ms.exemple.BankAccountMS.entities.BankAccount;
import ms.exemple.BankAccountMS.enums.AccountType;
import ms.exemple.BankAccountMS.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class BankAccountMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountMsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (BankAccountRepository  bankAccountRepository , CustomerRestClient customerRestClient){
		return args->{
			customerRestClient.allCustomers().forEach(c->{
				BankAccount bankAccount1=BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.currency("MAD")
						.solde(Math.random()*9800)
						.DateCreation(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(c.getId())
						.build();
				BankAccount bankAccount2=BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.currency("MAD")
						.solde(Math.random()*7855)
						.DateCreation(LocalDate.now())
						.type(AccountType.SAVING_ACCOUNT)
						.customerId(c.getId())
						.build();

				bankAccountRepository.save(bankAccount1);
				bankAccountRepository.save(bankAccount2);



			});



		};
	}
}

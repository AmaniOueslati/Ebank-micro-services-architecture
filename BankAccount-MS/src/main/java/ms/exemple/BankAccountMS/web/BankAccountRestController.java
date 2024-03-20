package ms.exemple.BankAccountMS.web;

import lombok.AllArgsConstructor;
import ms.exemple.BankAccountMS.clients.CustomerRestClient;
import ms.exemple.BankAccountMS.entities.BankAccount;
import ms.exemple.BankAccountMS.model.Customer;
import ms.exemple.BankAccountMS.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository ;
    private CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){



        List<BankAccount> accountList= bankAccountRepository.findAll();
        accountList.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return  accountList ;
    }


    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable  String id ){


   BankAccount bankAccount= bankAccountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}

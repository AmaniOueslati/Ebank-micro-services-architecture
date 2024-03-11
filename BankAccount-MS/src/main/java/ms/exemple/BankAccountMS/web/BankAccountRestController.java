package ms.exemple.BankAccountMS.web;

import ms.exemple.BankAccountMS.entities.BankAccount;
import ms.exemple.BankAccountMS.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository ;

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        return  bankAccountRepository.findAll();
    }


    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable  String id ){

        return  bankAccountRepository.findById(id).get();
    }
}

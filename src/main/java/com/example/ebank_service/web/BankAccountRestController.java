package com.example.ebank_service.web;

import com.example.ebank_service.entities.BankAccount;
import com.example.ebank_service.repository.BankAccountRepository;
import lombok.experimental.Delegate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BankAccountRestController {

    private BankAccountRepository bankAccountRepository;

    public BankAccountRestController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount getAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
    }

    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@RequestBody BankAccount bankAccount,@PathVariable String id ){
        bankAccount.setId(id);
        return bankAccountRepository.save(bankAccount);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }



}

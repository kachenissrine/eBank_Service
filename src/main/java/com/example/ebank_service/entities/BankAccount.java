package com.example.ebank_service.entities;

import com.example.ebank_service.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {

    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private AccountType Type;
    private String currency;
}

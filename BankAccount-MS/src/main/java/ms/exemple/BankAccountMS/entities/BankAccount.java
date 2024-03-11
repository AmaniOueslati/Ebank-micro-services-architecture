package ms.exemple.BankAccountMS.entities;

import jakarta.persistence.*;
import lombok.*;
import ms.exemple.BankAccountMS.enums.AccountType;
import ms.exemple.BankAccountMS.model.Customer;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {
    @Id

    private String id ;
    private double solde ;
    private LocalDate DateCreation ;
    private String currency ;
    @Enumerated(EnumType.STRING)
    private AccountType type ;
    //private Customer customer on peut pass le faire car customer n'est plus nune entites jpa de mon micro service  il est gerer par un autre micro service
    //le seul moyen pour dire que ce compte appartiet a un tel client c'est d'avoir cote bd la cle etrangere d'ou l'attribut customerId
    private Long customerId ;
    //autre solution on creer un package model on fait classe customer qui n'est pas entites jpa mais un model
    @Transient
    // pour ne pas creer cette attribut au niveau la base de donnee car cet attribut on va pas la chercher apres a travers la bd mais dans un autre micro service
    private Customer customer ;

}
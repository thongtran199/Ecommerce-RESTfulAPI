package com.thong.databaseMysql.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentID")
    private Integer id;

    @Column(name = "CardType")
    private String cardType;

    @Column(name = "CreditCard")
    private String creditCard;

    @Column(name = "CredExpMo")
    private Integer credExpMo;

    @Column(name = "CredExpYr")
    private Integer credExpYr;
}

package com.thong.databaseMysql.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private UserEntity userEntity;

    @Column(name = "Total")
    private Float total;

    @Column(name = "PaymentID")
    private Integer paymentID;

    @Column(name = "PaymentDate")
    private Date paymentDate;

    @Column(name = "OrderDate")
    private Date orderDate;

    @Column(name = "ShippingID")
    private Integer shippingID;

    @Column(name = "Status")
    private Integer status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SellerID")
    private UserEntity sellerEntity;

    @Column(name = "IsActive")
    private Boolean isActive;
}

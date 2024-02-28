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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PaymentID")
    private PaymentEntity paymentEntity;

    @Column(name = "PaymentDate")
    private Date paymentDate;

    @Column(name = "OrderDate")
    private Date orderDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ShippingID")
    private ShipmentEntity shipmentEntity;

    @Column(name = "Status")
    private Integer status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SellerID")
    private UserEntity sellerEntity;

    @Column(name = "IsActive")
    private Boolean isActive;
}

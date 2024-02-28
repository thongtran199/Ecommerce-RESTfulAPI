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
@Table(name = "order_detail")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private ProductEntity productEntity;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "UnitPrice")
    private Float unitPrice;
}

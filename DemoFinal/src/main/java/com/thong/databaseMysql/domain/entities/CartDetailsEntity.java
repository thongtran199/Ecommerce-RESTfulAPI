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
@Table(name = "cart_detail")
public class CartDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartDetailID")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CartID")
    private CartEntity cartEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProductID")
    private ProductEntity productEntity;

    @Column(name = "UnitPrice")
    private Float unitPrice;

    @Column(name = "Quantity")
    private Integer quantity;
}

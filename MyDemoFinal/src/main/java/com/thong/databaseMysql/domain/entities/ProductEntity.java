package com.thong.databaseMysql.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
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
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Integer id;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "UnitPrice")
    private Float unitPrice;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Color")
    private String color;

    @Column(name = "Image", columnDefinition = "TEXT")
    private String image;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "IsActive")
    private Boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SupplierID")
    private SupplierEntity supplierEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CategoryID")
    private CategoryEntity categoryEntity;

}

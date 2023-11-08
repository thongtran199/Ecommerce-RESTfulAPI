package com.thong.databaseMysql.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Integer id;

    @Column(name = "CategoryName")
    private String categoryName;

    @Column(name = "Image")
    private String image;

    @Column(name = "IsActive")
    private Boolean isActive;

//    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL)
//    private List<ProductEntity> productEntities;
}

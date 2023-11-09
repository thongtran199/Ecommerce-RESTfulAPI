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
@Table(name = "supplier")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupplierID")
    private Integer id;

    @Column(name = "CompanyName", columnDefinition = "TEXT")
    private String companyName;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Zipcode")
    private String zipcode;

    @Column(name = "Country")
    private String country;

    @Column(name = "ContactPerson")
    private String contactPerson;

    @Column(name = "ContactNumber")
    private String contactNumber;

    @Column(name = "ContactEmail")
    private String contactEmail;

    @Column(name = "ContactFax")
    private String contactFax;

    @Column(name = "IsActive")
    private Boolean isActive;
}

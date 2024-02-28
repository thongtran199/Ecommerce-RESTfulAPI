package com.thong.databaseMysql.domain.dto;

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
public class SupplierDto {
    private Integer id;

    private String companyName;

    private String address;

    private String city;

    private String state;

    private String zipcode;

    private String country;

    private String contactPerson;

    private String contactNumber;

    private String contactEmail;

    private String contactFax;

    private Boolean isActive;
}

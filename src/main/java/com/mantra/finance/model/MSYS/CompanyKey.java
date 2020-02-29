package com.mantra.finance.model.MSYS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "COMPANYKEY", schema = "MSEC")
@Data
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class CompanyKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String faTitle;

    private String enTitle;

    private String code;

    private Boolean isDeleted;

    private Integer mantraKey;

}

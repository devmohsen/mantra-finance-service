package com.mantra.finance.model.MGNR;


import com.mantra.finance.model.MSYS.AccountType;
import com.mantra.finance.model.MSYS.PersonalityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "DETAILACCOUNT", schema = "MGNR")
@Data
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class DetailAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COMPANYID")
    private Company companyId;

    @ManyToOne
    @JoinColumn(name = "BRANCHID")
    private Branch branchId;

    @ManyToOne
    @JoinColumn(name = "DETAILACCOUNTGROUPID")
    private DetailAccountGroup detailAccountGroupId;

    @Column(name = "CODE")
    private Long code;

    @Column(name = "ISACTIVE")
    private Boolean isActive;

    @OneToOne
    @JoinColumn(name = "PERSONALITYTYPEID")
    private PersonalityType personalityType;

    @Column(name = "ISSUPPLIER")
    private Boolean isSupplier;

    @Column(name = "ISMARKETER")
    private Boolean isMarketer;

    @Column(name = "ISCUSTOMER")
    private Boolean isCustomer;

    @Column(name = "ISOTHER")
    private Boolean isOther;

    @Column(name = "ISPERSONNEL")
    private Boolean isPersonnel;

    @Column(name = "TITLE")
    @Length(min = 3, max = 150)
    private String title;

    @Column(name = "NAME")
    @Length(min = 3, max = 50)
    private String name;

    @Column(name = "FAMILY")
    @Length(min = 3, max = 100)
    private String family;

    @Column(name = "LEGALTITLE")
    @Length(min = 3, max = 100)
    private String legalTitle;

    @Column(name = "NATIONALCODE")
    @Length(min = 10, max = 10)
    private String nationalCode;

    @Column(name = "ECONOMICCODE")
    private Integer economicCode;

    @Column(name = "NATIONALID")
    private Integer nationalId;

    @Column(name = "REGISTERNO")
    private Integer registerNo;

    @Column(name = "WEBSITE")
    @Length(min = 10, max = 50)
    private String website;

    @Column(name = "EMAIL")
    @Length(max = 50)
    private String email;

    @OneToOne
    @JoinColumn(name = "OWNERID")
    private DetailAccount owner;



}

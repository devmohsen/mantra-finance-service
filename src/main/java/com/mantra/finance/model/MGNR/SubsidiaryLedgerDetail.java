package com.mantra.finance.model.MGNR;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SUBSIDIARYLEDGERDETAIL", schema = "MGNR")
@Data
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class SubsidiaryLedgerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "SUBSIDIARYLEDGERID")
    private SubsidiaryLedger subsidiaryLedgerId;
    @OneToOne
    @JoinColumn(name = "DETAILACCOUNTGROUPID")
    private DetailAccountGroup detailAccountGroupId;


    private Boolean isDeleted;

}

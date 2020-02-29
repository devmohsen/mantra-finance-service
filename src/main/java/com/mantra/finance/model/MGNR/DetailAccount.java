package com.mantra.finance.model.MGNR;


import com.mantra.finance.model.MSYS.PersonalityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

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


}

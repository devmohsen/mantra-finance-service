package com.mantra.finance.model.MGNR;


import com.mantra.finance.model.MSYS.DetailAccountGroupLevel;
import com.mantra.finance.model.MSYS.DetailAccountGroupType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DETAILACCOUNTGROUP", schema = "MGNR")
@Data
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class DetailAccountGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Length(min = 2, max = 100)
    @NotNull
    @NotBlank
    private String faTitle;

    @Length(min = 2, max = 50)
    @NotNull
    @NotBlank
    private String enTitle;
    @NotNull
    private Integer code;

    @ManyToOne
    @JoinColumn(name = "COMPANYID")
    private Company companyId;

    @ManyToOne
    @JoinColumn(name = "DETAILACCOUNTGROUPTYPEID")
    @NotNull
    private DetailAccountGroupType detailAccountGroupTypeId;

    @ManyToOne
    @JoinColumn(name = "DETAILACCOUNTGROUPLEVELID")
    @NotNull
    private DetailAccountGroupLevel detailAccountGroupLevelId;

    @Builder.Default
    private boolean isDeleted =false;


}

package com.mantra.finance.model.MGNR;

import com.mantra.finance.model.MSYS.CompanyKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMPANY", schema = "MGNR")
@Data
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Company implements Serializable {

    private static final long serialVersionUID = -343928414972524678L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "companyKeyId")
    private CompanyKey companyKeyId;

    private String faTitle;

    private String enTitle;

    private String code;

    private Boolean isDeleted;


}

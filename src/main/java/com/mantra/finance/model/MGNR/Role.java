package com.mantra.finance.model.MGNR;

import com.mantra.finance.model.MGNR.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ROLE", schema = "MGNR")
@Data
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String title;

    private String code;
    private boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company companyId;
}

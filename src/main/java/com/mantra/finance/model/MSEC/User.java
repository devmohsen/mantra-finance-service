package com.mantra.finance.model.MSEC;

import com.mantra.finance.model.MGNR.Company;
import com.mantra.finance.model.MGNR.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "USERS", schema = "MSEC")
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private Boolean isActive = true;
    private Date expireDate;
    @OneToOne
    @JoinColumn(name = "personId")
    private Person personId;

    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company companyId;


}

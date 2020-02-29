package com.mantra.finance.model.MSYS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PERSONALITYTYPE", schema = "MSYS")
@Data
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class PersonalityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ENTITLE")
    private String enTitle;

    @Column(name = "FATITLE")
    private String faTitle;
}

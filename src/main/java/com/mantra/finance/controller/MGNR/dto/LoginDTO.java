package com.mantra.finance.controller.MGNR.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
//@EntityScan
@Entity
public class LoginDTO {
    @Id
    private long id;
    private Long userId;
    private String username;
    private String password;
    private String roleTitle;
    private String firstname;
    private String family;
    private Long personId;
    private Integer personnelCode;
    private Integer companyId;
    private Integer mantraKey;

    public LoginDTO(Long userId, Integer companyId, String username, String password, String roleTitle,
                    String firstname, String family, Long personId, Integer personnelCode, Integer mantraKey) {
        this.userId = userId;
        this.companyId = companyId;
        this.username = username;
        this.password = password;
        this.roleTitle = roleTitle;
        this.firstname = firstname;
        this.family = family;
        this.personId = personId;
        this.personnelCode = personnelCode;
        this.mantraKey = mantraKey;

    }
}

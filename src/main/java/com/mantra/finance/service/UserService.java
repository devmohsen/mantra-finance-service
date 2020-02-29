package com.mantra.finance.service;


import com.mantra.finance.controller.MGNR.dto.LoginDTO;
import com.mantra.finance.model.MGNR.RolePermission;
import com.mantra.finance.repository.LoginDTORepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {


    private final LoginDTORepository loginDTORepository;


    public Collection<LoginDTO> getLoginDto(final String username, final int mantraKey) {

        return loginDTORepository.getRoleForLogin(username, mantraKey).get();

    }

    public Set<GrantedAuthority> getGrantedAuthoritiesList(Collection<RolePermission> rolePermissions) {
        Set<GrantedAuthority> grantedAuthoritiesList = new HashSet<>();
        for (RolePermission rolePermission : rolePermissions) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rolePermission.getPermissionId().getEnTitle());
            grantedAuthoritiesList.add(grantedAuthority);
        }
        return grantedAuthoritiesList;
    }
}

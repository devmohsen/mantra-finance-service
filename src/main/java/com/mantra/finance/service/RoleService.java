package com.mantra.finance.service;

import com.mantra.finance.model.MGNR.Role;
import com.mantra.finance.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;


    public Role create(Role role) {
        return roleRepository.save(role);
    }

}

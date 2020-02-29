package com.mantra.finance.service.MSYS;

import com.mantra.finance.model.MSYS.Menu;
import com.mantra.finance.repository.MSYS.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<Menu> getPersonMenu(Integer personId, Integer companyId) {
        System.out.println("personId " + personId + " companyId " + companyId);
        Optional<List<Menu>> optionalMenuList = menuRepository.getPersonMenu(personId, companyId);
        if (optionalMenuList.isEmpty()) {
            return new ArrayList<>();
        }
        return optionalMenuList.get();
    }
}

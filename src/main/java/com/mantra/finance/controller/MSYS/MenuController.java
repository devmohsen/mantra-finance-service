package com.mantra.finance.controller.MSYS;


import com.mantra.finance.model.MSYS.Menu;
import com.mantra.finance.service.MSYS.MenuService;
import com.mantra.finance.tools.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("menu")
@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;
    private final JwtUtil jwtUtil;

    @GetMapping("person-menu")
    public ResponseEntity<List<Menu>> getPersonMenu(HttpServletRequest request) {
        Integer companyId = jwtUtil.getCompanyIdFromHeader(request);
        Integer personId = jwtUtil.getPersonIdFromHeader(request);
        return ResponseEntity.ok(menuService.getPersonMenu(personId, companyId));
    }


}

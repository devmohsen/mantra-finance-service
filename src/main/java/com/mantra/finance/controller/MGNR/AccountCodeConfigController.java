package com.mantra.finance.controller.MGNR;


import com.mantra.finance.exception.ExpectedTokenValueException;
import com.mantra.finance.model.MGNR.AccountCodeConfig;
import com.mantra.finance.service.MGNR.AccountCodeConfigService;
import com.mantra.finance.tools.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("account-code-config")
@RequiredArgsConstructor
public class AccountCodeConfigController {

    private final JwtUtil jwtUtil;
    private final AccountCodeConfigService service;

    @GetMapping
    public ResponseEntity<AccountCodeConfig> getOne(HttpServletRequest request) throws ExpectedTokenValueException {
        Integer companyId = jwtUtil.getCompanyIdFromHeader(request);
        return ResponseEntity.ok(service.getOne(companyId));
    }

    @PutMapping
    public ResponseEntity<AccountCodeConfig> update(@RequestBody AccountCodeConfig codeConfig) {
        return ResponseEntity.ok(service.update(codeConfig));
    }
}

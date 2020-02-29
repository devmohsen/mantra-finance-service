package com.mantra.finance.controller.MGNR;


import com.mantra.finance.controller.MGNR.dto.CompleteAccountListDTO;
import com.mantra.finance.exception.ExpectedTokenValueException;
import com.mantra.finance.model.MGNR.AccountGroup;
import com.mantra.finance.model.MGNR.Company;
import com.mantra.finance.service.MGNR.AccountGroupService;
import com.mantra.finance.tools.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("account-group")
@RequiredArgsConstructor
public class AccountGroupController {


    private final AccountGroupService accountGroupService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<AccountGroup> create(@RequestBody AccountGroup accountGroup,HttpServletRequest request) {
        Integer companyId = jwtUtil.getCompanyIdFromHeader(request);
        if (companyId == null) {
            throw new ExpectedTokenValueException("error.token.value.exception", "companyId");
        }
        accountGroup.setCompanyId(Company.builder().id(companyId).build());
        return ResponseEntity.ok(accountGroupService.create(accountGroup));
    }

    @PutMapping
    public ResponseEntity<AccountGroup> update(@RequestBody AccountGroup accountGroup) {
        return ResponseEntity.ok(accountGroupService.update(accountGroup));
    }

    @DeleteMapping
    public ResponseEntity<AccountGroup> deleteOne(@RequestParam("id") Integer id, HttpServletRequest request) {
        Integer companyId = jwtUtil.getCompanyIdFromHeader(request);
        return ResponseEntity.ok(accountGroupService.deleteOne(id, companyId));
    }

    @GetMapping("complete-account-list")
    public ResponseEntity<List<CompleteAccountListDTO>> getCompleteAccountList(HttpServletRequest request) {
        Integer companyId = jwtUtil.getCompanyIdFromHeader(request);
        return ResponseEntity.ok(accountGroupService.getCompleteAccountList(companyId));
    }
}

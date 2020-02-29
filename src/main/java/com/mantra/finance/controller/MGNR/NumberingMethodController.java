package com.mantra.finance.controller.MGNR;


import com.mantra.finance.model.MGNR.NumberingMethod;
import com.mantra.finance.service.MGNR.NumberingMethodService;
import com.mantra.finance.tools.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("numbering-method")
@RequiredArgsConstructor
public class NumberingMethodController {

    private final NumberingMethodService numberingMethodService;
    private final JwtUtil jwtUtil;


    @GetMapping
    public ResponseEntity<List<NumberingMethod>> getAll(HttpServletRequest request) {
        Integer companyId = jwtUtil.getCompanyIdFromHeader(request);
        return ResponseEntity.ok(numberingMethodService.getAll(companyId));
    }

    @PostMapping
    public ResponseEntity<NumberingMethod> create(@RequestBody @Valid NumberingMethod numberingMethod,
                                                  HttpServletRequest request) {

        Integer companyId = jwtUtil.getCompanyIdFromHeader(request);
        numberingMethod.setCompanyId(companyId);
        return ResponseEntity.ok(numberingMethodService.create(numberingMethod));
    }

    @DeleteMapping
    public ResponseEntity<NumberingMethod> delete(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(numberingMethodService.delete(id));
    }

    @PutMapping
    public ResponseEntity<NumberingMethod> update(@RequestBody @Valid NumberingMethod numberingMethod, HttpServletRequest request) {

        return this.create(numberingMethod, request);
    }
}

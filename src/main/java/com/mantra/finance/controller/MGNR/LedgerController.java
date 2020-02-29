package com.mantra.finance.controller.MGNR;

import com.mantra.finance.controller.MGNR.dto.LedgerDTO;
import com.mantra.finance.model.MGNR.Ledger;
import com.mantra.finance.service.MGNR.LedgerService;
import com.mantra.finance.tools.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("ledger")
@RequiredArgsConstructor
public class LedgerController {

    private final LedgerService ledgerService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<LedgerDTO> create(@RequestBody @Valid LedgerDTO dto,
                                            HttpServletRequest request) {
        Integer companyId = jwtUtil.getCompanyIdFromHeader(request);
        Ledger ledger = ledgerService.create(dto.toModel(companyId));
        return ResponseEntity.ok(LedgerDTO.fromModel(ledger));
    }

    @PutMapping
    public ResponseEntity<LedgerDTO> update(@RequestBody @Valid LedgerDTO dto,
                                            HttpServletRequest request) {
        Integer companyId = jwtUtil.getCompanyIdFromHeader(request);
        Ledger ledger = ledgerService.update(dto.toModel(companyId));
        return ResponseEntity.ok(LedgerDTO.fromModel(ledger));
    }

    @GetMapping
    public ResponseEntity<List<Ledger>> getAll(HttpServletRequest request) {
        Integer companyId = jwtUtil.getCompanyIdFromHeader(request);

        return ResponseEntity.ok(ledgerService.getAll(companyId));
    }

    @DeleteMapping
    public ResponseEntity<Ledger> delete(@RequestParam("id") Integer id, HttpServletRequest request) {
        Integer companyId = jwtUtil.getCompanyIdFromHeader(request);
        return ResponseEntity.ok(ledgerService.delete(companyId, id));
    }


    @GetMapping("get-one")
    public ResponseEntity<Ledger> getOne(@RequestParam("id") Integer id,HttpServletRequest request) {
        Integer companyId = jwtUtil.getCompanyIdFromHeader(request);

        return ResponseEntity.ok(ledgerService.getOne(id,companyId));

    }


}

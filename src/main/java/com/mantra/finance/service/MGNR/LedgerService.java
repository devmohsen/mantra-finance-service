package com.mantra.finance.service.MGNR;

import com.mantra.finance.model.MGNR.Ledger;

import java.util.List;

public interface LedgerService {
    Ledger create(Ledger ledger);

    Ledger update(Ledger ledger);

    List<Ledger> getAll(Integer companyId);

    Ledger delete(Integer companyId, Integer id);

    Ledger getOne(Integer id, Integer companyId);
}

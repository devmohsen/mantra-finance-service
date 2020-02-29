package com.mantra.finance.service.MGNR;

import com.mantra.finance.model.MGNR.SubsidiaryLedger;

import java.util.List;

public interface SubsidiaryLedgerService {
    SubsidiaryLedger create(SubsidiaryLedger subsidiaryLedger);

    SubsidiaryLedger update(SubsidiaryLedger subsidiaryLedger);

    SubsidiaryLedger delete(Integer id);

    List<SubsidiaryLedger> getAll(Integer companyId);

    SubsidiaryLedger getById(Integer id);
}

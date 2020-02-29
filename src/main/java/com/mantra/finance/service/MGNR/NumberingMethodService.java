package com.mantra.finance.service.MGNR;

import com.mantra.finance.model.MGNR.NumberingMethod;

import java.util.List;

public interface NumberingMethodService {
    List<NumberingMethod> getAll(Integer companyId);

    NumberingMethod create(NumberingMethod numberingMethod);

    NumberingMethod delete(Integer id);
}

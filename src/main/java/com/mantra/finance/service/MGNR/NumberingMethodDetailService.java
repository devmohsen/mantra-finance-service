package com.mantra.finance.service.MGNR;

import com.mantra.finance.model.MGNR.NumberingMethodDetail;

import java.util.List;

public interface NumberingMethodDetailService {
    NumberingMethodDetail create(NumberingMethodDetail numberingMethodDetail);

    List<NumberingMethodDetail> getAll(Integer companyId);

    NumberingMethodDetail getOne(Integer id);

    NumberingMethodDetail delete(Integer id);
}

package com.mantra.finance.service.MGNR;

import com.mantra.finance.model.MGNR.DetailAccountGroup;

import java.util.Set;

public interface DetailAccountGroupService {
    Set<DetailAccountGroup> getAll(Integer companyId);

    DetailAccountGroup delete(Integer id);

    DetailAccountGroup getOne(Integer id);

    DetailAccountGroup create(DetailAccountGroup detailAccountGroup);

    DetailAccountGroup update(DetailAccountGroup detailAccountGroup);
}

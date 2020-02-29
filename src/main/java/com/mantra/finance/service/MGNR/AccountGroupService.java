package com.mantra.finance.service.MGNR;

import com.mantra.finance.controller.MGNR.dto.CompleteAccountListDTO;
import com.mantra.finance.model.MGNR.AccountGroup;

import java.util.List;

public interface AccountGroupService {
    AccountGroup create(AccountGroup accountGroup);

    AccountGroup update(AccountGroup accountGroup);

    AccountGroup deleteOne(Integer id, Integer companyId);

    List<CompleteAccountListDTO> getCompleteAccountList(Integer companyId);
}

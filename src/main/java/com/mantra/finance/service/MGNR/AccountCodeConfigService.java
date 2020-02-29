package com.mantra.finance.service.MGNR;

import com.mantra.finance.model.MGNR.AccountCodeConfig;

public interface AccountCodeConfigService {
    AccountCodeConfig getOne(Integer companyId);

    AccountCodeConfig update(AccountCodeConfig codeConfig);
}

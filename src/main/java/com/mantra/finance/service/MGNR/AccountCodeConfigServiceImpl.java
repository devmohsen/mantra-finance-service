package com.mantra.finance.service.MGNR;

import com.mantra.finance.exception.ClientException;
import com.mantra.finance.model.MGNR.AccountCodeConfig;
import com.mantra.finance.repository.MGNR.AccountCodeConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountCodeConfigServiceImpl implements AccountCodeConfigService {

    private final AccountCodeConfigRepository repository;

    @Override
    public AccountCodeConfig getOne(Integer companyId) {
        Optional<AccountCodeConfig> optionalAccountCodeConfig = repository.findByCompanyId_Id(companyId);

        if (optionalAccountCodeConfig.isEmpty()) {
            throw new ClientException("error.account.code.config.not.found");
        }
        return optionalAccountCodeConfig.get();
    }

    @Override
    public AccountCodeConfig update(AccountCodeConfig codeConfig) {
        Optional<AccountCodeConfig> optionalAccountCodeConfig = repository.findById(codeConfig.getId());
        if (optionalAccountCodeConfig.isEmpty()) {
            throw new ClientException("error.account.code.config.not.found");
        }
        if (codeConfig.getLenLedger() <= codeConfig.getLenGroup()) {
            throw new ClientException("error.ledger.code.length.smaller.than.group");
        }
        if (codeConfig.getLenSubsidiary() <= codeConfig.getLenLedger()) {
            throw new ClientException("error.subsidiaryLedger.code.length.smaller.than.ledger");
        }
        return repository.save(codeConfig);
    }
}

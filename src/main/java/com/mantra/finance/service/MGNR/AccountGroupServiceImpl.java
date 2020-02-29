package com.mantra.finance.service.MGNR;

import com.mantra.finance.controller.MGNR.dto.CompleteAccountListDTO;
import com.mantra.finance.exception.ClientException;
import com.mantra.finance.exception.ServerException;
import com.mantra.finance.model.MGNR.AccountCodeConfig;
import com.mantra.finance.model.MGNR.AccountGroup;
import com.mantra.finance.model.MGNR.Ledger;
import com.mantra.finance.repository.MGNR.AccountCodeConfigRepository;
import com.mantra.finance.repository.MGNR.accountGroup.AccountGroupRepository;
import com.mantra.finance.repository.MGNR.accountGroup.CustomAccountGroupRepository;
import com.mantra.finance.repository.MGNR.LedgerRepository;
import com.mantra.finance.tools.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountGroupServiceImpl implements AccountGroupService {

    private final AccountGroupRepository repository;
    private final AccountCodeConfigRepository accountCodeConfigRepository;
    private final LedgerRepository ledgerRepository;
    private final CustomAccountGroupRepository customRepository;

    @Override
    @Transactional
    public AccountGroup create(AccountGroup accountGroup) {
        Optional<AccountCodeConfig> optionalAccountCodeConfig =
                accountCodeConfigRepository.findByCompanyId_Id(accountGroup.getCompanyId().getId());

        if (optionalAccountCodeConfig.isEmpty()) {
            throw new ClientException("error.account.code.config.not.found");
        }
        System.out.println("accountGroup.getCode().toString().length(): " + accountGroup.getCode().toString().length());
        System.out.println("optionalAccountCodeConfig.get().getLenGroup(): " + optionalAccountCodeConfig.get().getLenGroup());
        if (accountGroup.getCode().toString().length() != optionalAccountCodeConfig.get().getLenGroup()) {
            throw new ClientException("error.code.length");
        }
        accountGroup.setFaTitle(StringUtil.replaceArabicChars(accountGroup.getFaTitle()));
        try {

            return repository.save(accountGroup);

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new ClientException("error.unique.constrains.violation", StringUtil.getUniquePropertyFromException(e));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException("error.internal.server");
        }
    }

    @Override
    @Transactional
    public AccountGroup update(AccountGroup accountGroup) {
        Optional<AccountGroup> optionalAccountGroup = repository.findById(accountGroup.getId());

        if (optionalAccountGroup.isEmpty()) {
            throw new ClientException("error.account.group.not.found", String.valueOf(accountGroup.getId()));
        }

        Optional<Ledger> optionalLedger = ledgerRepository
                .findByCompanyIdAndAccountGroupId(accountGroup.getCompanyId().getId(), accountGroup.getId());

        if (optionalLedger.isPresent()) {
            accountGroup.setAccountGroupTypeId(optionalAccountGroup.get().getAccountGroupTypeId());
            accountGroup.setCode(optionalAccountGroup.get().getCode());
            accountGroup.setCompanyId(optionalAccountGroup.get().getCompanyId());
        }
        return repository.save(accountGroup);
    }

    @Override
    @Transactional
    public AccountGroup deleteOne(Integer id, Integer companyId) {

        Optional<AccountGroup> optionalAccountGroup = repository.findById(id);

        if (optionalAccountGroup.isEmpty()) {
            throw new ClientException("error.account.group.not.found", String.valueOf(id));
        }

        Optional<Ledger> optionalLedger = ledgerRepository
                .findByCompanyIdAndAccountGroupId(id, companyId);

        if (optionalLedger.isPresent()) {
            throw new ClientException("error.unable.delete.account.group");
        }
        repository.makeAccountDeleted(id);
        return optionalAccountGroup.get();
    }

    @Override
    public List<CompleteAccountListDTO> getCompleteAccountList(Integer companyId) {

        Optional<List<CompleteAccountListDTO>> optionalCompleteAccountListDTO =
                customRepository.getCompleteAccountList(companyId);

        return optionalCompleteAccountListDTO.orElseGet(() -> Collections.singletonList(CompleteAccountListDTO.builder().build()));
    }
}

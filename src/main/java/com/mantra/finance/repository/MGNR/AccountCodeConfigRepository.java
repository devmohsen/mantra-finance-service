package com.mantra.finance.repository.MGNR;

import com.mantra.finance.model.MGNR.AccountCodeConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountCodeConfigRepository extends JpaRepository<AccountCodeConfig, Integer> {

    Optional<AccountCodeConfig> findByCompanyId_Id(Integer companyId);
}

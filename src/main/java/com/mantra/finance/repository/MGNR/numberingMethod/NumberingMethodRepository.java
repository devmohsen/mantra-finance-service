package com.mantra.finance.repository.MGNR.numberingMethod;

import com.mantra.finance.model.MGNR.NumberingMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NumberingMethodRepository extends JpaRepository<NumberingMethod, Integer>, CustomNumberingMethodRepository {
}

interface CustomNumberingMethodRepository {
    Optional<List<NumberingMethod>> getAll(Integer companyId);

    NumberingMethod create(NumberingMethod numberingMethod);
}


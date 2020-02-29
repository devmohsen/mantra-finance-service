package com.mantra.finance.service.MGNR;

import com.mantra.finance.controller.MGNR.dto.CreatePersonDTO;
import com.mantra.finance.controller.MGNR.dto.UpdatePersonDTO;
import com.mantra.finance.model.MGNR.Person;

import java.util.List;

public interface PersonService {
    Person create(CreatePersonDTO dto);

    List<Person> findAll(Integer companyId);

    Person update(UpdatePersonDTO dto);

    Person getOne(Long id);

    Person delete(Long id);
}

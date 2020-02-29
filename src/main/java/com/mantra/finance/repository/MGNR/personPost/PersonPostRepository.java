package com.mantra.finance.repository.MGNR.personPost;

import com.mantra.finance.model.MGNR.Person;
import com.mantra.finance.model.MGNR.PersonPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonPostRepository extends JpaRepository<PersonPost, Long> {
    Optional<PersonPost> findByPersonId(Person personId);


}

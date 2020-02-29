package com.mantra.finance.repository.MGNR.person;

import com.mantra.finance.model.MGNR.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, CustomPersonRepository{
    Optional<Person> findByNationalCode(String nationalCode);

    Optional<Person> findByIdAndIsDeletedIsFalse(Long id);
    Optional<List<Person>> findAllByIsDeletedIsFalseAndCompanyId_Id(@Param("companyId") Integer companyId);

}


 interface CustomPersonRepository {
//    Optional<GetPersonDTO> getOne(Long id);
    void makePersonDeleted(Long id);
}

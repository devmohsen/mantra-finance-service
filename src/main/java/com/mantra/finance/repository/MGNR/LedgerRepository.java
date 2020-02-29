package com.mantra.finance.repository.MGNR;

import com.mantra.finance.model.MGNR.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LedgerRepository extends JpaRepository<Ledger, Integer> {


    @Query(value = "SELECT ledger.id FROM MGNR.LEDGER ledger where ledger.ACCOUNTGROUPID=:accountGroupId " +
            " AND ledger.COMPANYID=:companyId AND ledger.ISDELETED=0 LIMIT 1", nativeQuery = true)
    Optional<Ledger> findByCompanyIdAndAccountGroupId(@Param("companyId") Integer companyId,
                                                      @Param("accountGroupId") Integer accountGroupId);

    @Query(value = "SELECT * FROM MGNR.LEDGER WHERE COMPANYID=:companyId AND ISDELETED=0", nativeQuery = true)
    Optional<List<Ledger>> findAllByCompanyId(@Param("companyId") Integer companyId);

    @Query(value = "UPDATE MGNR.LEDGER SET ISDELETED=1 WHERE ID =:id", nativeQuery = true)
    void makeLedgerDeleted(Integer id);

    Optional<Ledger> findByIdAndCompanyId_IdAndIsDeletedIsFalse(Integer id, Integer companyId);

}

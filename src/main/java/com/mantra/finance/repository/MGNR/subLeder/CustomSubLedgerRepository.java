package com.mantra.finance.repository.MGNR.subLeder;

import com.mantra.finance.tools.Print;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CustomSubLedgerRepository {

    private final EntityManager entityManager;

    public void makeSubLedgerDeletedById(Integer id) {

        entityManager.joinTransaction();
        Session session = (Session) entityManager.getDelegate();
        String sql = "UPDATE MGNR.SUBSIDIARYLEDGER SET ISDELETED=1 WHERE ID = " + id;
        session.createSQLQuery(sql).executeUpdate();
    }
}
